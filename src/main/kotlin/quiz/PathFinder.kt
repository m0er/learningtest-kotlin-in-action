package quiz

import java.util.*

/**
 * Created by AidenChoi on 2016. 12. 5..
 */
class PathFinder {
    val subwayLines: MutableMap<Int, List<Station>> = HashMap()
    lateinit var startStation: Station
    lateinit var destStation: Station

    fun setSubwayLine(lineNumber: Int, stations: List<Station>) = subwayLines.put(lineNumber, stations)

    fun getSubwayLine(lineNumber: Int) = subwayLines[lineNumber]

    fun findOneByStationName(stationName: String) = findAllStationsByStationName(stationName).first()

    fun setStartStation(lineNumber: Int, stationName: String) {
        startStation = findStationByStationName(lineNumber, stationName)
    }

    fun setDestinationStation(lineNumber: Int, stationName: String) {
        destStation = findStationByStationName(lineNumber, stationName)
    }

    fun findPath() = if (startStation.isSameLine(destStation)) {
            subwayLines[startStation.lineNumber]?.apply {
                return subList(indexOf(startStation), indexOf(destStation) + 1)
            }
        } else {
            findTransferStationByLineNumber(startStation.lineNumber)?.let {
                val transferStations = mutableListOf(it)
                val pathStations = findAllStationsToDestStations(startStation, it)

                findDestStation(transferStations, pathStations)

                return pathStations
            }
        }

    internal fun findDestStation(transferStations: MutableList<Station>, pathStations: MutableList<Station>) {
        val transferStation = transferStations.last()
        findTransferStationByLineNumber(transferStation.transferLine)?.let { nextTransferStation ->
            transferStations.add(nextTransferStation)

            subwayLines[nextTransferStation.lineNumber]?.let {
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

    internal fun findTransferStationByLineNumber(lineNumber: Int) = subwayLines[lineNumber]!!.let { it.find { it.transferStation } }

    internal fun findAllStationsToDestStations(fromStation: Station, destStation: Station): MutableList<Station> {
        subwayLines[fromStation.lineNumber]!!.apply {
            val fromStationIndex = indexOf(fromStation)
            val transferStationIndex = indexOf(destStation)
            return subList(Math.min(fromStationIndex, transferStationIndex), Math.max(fromStationIndex, transferStationIndex) + 1).toMutableList()
        }
        return ArrayList()
    }

    internal fun findAllStationsByStationName(stationName: String) = subwayLines.map {
            it.value.find { it.title.equals(stationName) }
        }.filterNotNull()

    internal fun findStationByStationName(lineNumber: Int, stationName: String) = subwayLines.map {
            it.value.find { it.title.equals(stationName) && it.lineNumber == lineNumber }
        }.filterNotNull().first()
}

data class Station(val lineNumber:Int, val title: String, val transferStation: Boolean = false) {

    var transferLine = 0

    constructor(lineNumber:Int, title: String, transferLine: Int) : this(lineNumber, title, true) {
        this.transferLine = transferLine
    }

    fun isSameLine(otherStation: Station) = lineNumber == otherStation.lineNumber
}
