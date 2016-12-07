package quiz

import java.util.*

/**
 * Created by AidenChoi on 2016. 12. 5..
 */
class PathFinder {
    val subwayLines: MutableMap<Int, List<Station>> = HashMap()
    lateinit var startStation: Station
    lateinit var destStation: Station

    fun setStartStation(line: Int, title: String) {
        startStation = findStationByStationName(line, title)
    }

    fun setDestinationStation(line: Int, title: String) {
        destStation = findStationByStationName(line, title)
    }

    fun findPath() = if (startStation.isSameLine(destStation)) {
        subwayLines[startStation.line]?.apply {
            return subList(indexOf(startStation), indexOf(destStation) + 1)
        }
    } else {
        findTransferStationByLineNumber(startStation.line)?.let {
            val transferStations = mutableListOf(it)
            val pathStations = findAllStationsToDestStations(startStation, it)

            findDestStation(transferStations, pathStations)

            return pathStations
        }
    }

    fun findEveryPath(): List<List<Station>> {
        if (startStation.isSameLine(destStation)) {
            subwayLines[startStation.line]?.apply {
                return listOf(subList(indexOf(startStation), indexOf(destStation) + 1))
            }
        } else {
            val results = ArrayList<List<Station>>()

            subwayLines[startStation.line]?.forEach {
                if (it.transferStation) {
                    val transferStations = mutableListOf(it)
                    val pathStations = findAllStationsToDestStations(startStation, it)

                    findDestStation(transferStations, pathStations)

                    results.add(pathStations)
                }
            }

            return results
        }
        return emptyList()
    }

    internal fun setSubwayLine(line: Int, stations: List<Station>) = subwayLines.put(line, stations)

    internal fun getSubwayLine(line: Int) = subwayLines[line]

    internal fun findOneByStationName(stationName: String) = findAllStationsByStationName(stationName).first()

    internal fun findDestStation(transferStations: MutableList<Station>, pathStations: MutableList<Station>) {
        val transferStation = transferStations.last()
        findTransferStationByLineNumberAndTitle(transferStation.transferTo, transferStation.title)?.let { nextTransferStation ->
            transferStations.add(nextTransferStation)

            subwayLines[nextTransferStation.line]?.let {
                if (it.contains(destStation)) {
                    pathStations.addAll(findAllStationsToDestStations(nextTransferStation, destStation))
                } else {
                    transferStations.add(it.filter { it.transferStation && !it.equals(nextTransferStation) }.first())
                    pathStations.addAll(findAllStationsToDestStations(nextTransferStation, transferStations.last()))
                    findDestStation(transferStations, pathStations)
                }
            }
        }
    }

    internal fun findTransferStationByLineNumberAndTitle(line: Int, title: String) = subwayLines[line]!!.let { it.find { it.transferStation && it.title.equals(title) } }

    internal fun findTransferStationByLineNumber(lineNumber: Int) = subwayLines[lineNumber]!!.let { it.find { it.transferStation } }

    internal fun findAllStationsToDestStations(fromStation: Station, destStation: Station): MutableList<Station> {
        subwayLines[fromStation.line]?.apply {
            val fromStationIndex = indexOf(fromStation)
            val transferStationIndex = indexOf(destStation)
            return subList(Math.min(fromStationIndex, transferStationIndex), Math.max(fromStationIndex, transferStationIndex) + 1).toMutableList().apply {
                if (!fromStation.equals(startStation) && !first().transferStation && last().transferStation) {
                    reverse()
                }
            }
        }
        return emptyList<Station>().toMutableList()
    }

    internal fun findAllStationsByStationName(title: String) = subwayLines.map {
        it.value.find { it.title.equals(title) }
    }.filterNotNull()

    internal fun findStationByStationName(line: Int, title: String) = subwayLines.map {
        it.value.find { it.title.equals(title) && it.line == line }
    }.filterNotNull().first()
}

data class Station(val line: Int, val title: String, val transferStation: Boolean = false) {
    var transferTo = 0

    constructor(lineNumber: Int, title: String, transferTo: Int) : this(lineNumber, title, transferStation = true) {
        this.transferTo = transferTo
    }

    fun isSameLine(otherStation: Station) = line == otherStation.line
}
