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
                subList(indexOf(startStation), indexOf(destStation) + 1)
            }
        } else {
            findAllStationsToTransferStations(startStation, destStation.lineNumber).plus(findAllStationsToTransferStations(destStation, startStation.lineNumber))
        }

    fun findAllStationsToTransferStations(fromStation: Station, destTransferLine: Int): List<Station> {
        subwayLines[fromStation.lineNumber]?.apply {
            val transferStation = find { it.transferStation && destTransferLine == it.transferLine }
            val fromStationIndex = indexOf(fromStation)
            val transferStationIndex = indexOf(transferStation)
            return subList(Math.min(fromStationIndex, transferStationIndex), Math.max(fromStationIndex, transferStationIndex) + 1)
        }
        return emptyList()
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
