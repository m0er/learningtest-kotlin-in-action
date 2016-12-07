package quiz

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * Created by AidenChoi on 2016. 12. 5..
 */
class PathFinderTest {
    var pathFinder = PathFinder()

    @Before
    fun setUp() {
        pathFinder.setSubwayLine(1, listOf(Station(1, "A"), Station(1, "B"), Station(1, "C", 2), Station(1, "D"), Station(1, "Z", 4)))
        pathFinder.setSubwayLine(2, listOf(Station(2, "C", 1), Station(2, "E"), Station(2, "F", 3)))
        pathFinder.setSubwayLine(3, listOf(Station(3, "G"), Station(3, "F", 2), Station(3, "H"), Station(3, "I", 4)))
        pathFinder.setSubwayLine(4, listOf(Station(4, "I", 3), Station(4, "J"), Station(4, "K"), Station(4, "Z", 1)))
    }

    @Test
    fun _길찾기는_노선과_역을_가지고_있다() {
        val subwayLine = pathFinder.getSubwayLine(1)
        assertNotNull(subwayLine)
        assertNotNull(subwayLine?.size?.compareTo(0) != -1)
    }

    @Test
    fun _시작_역을_지정할_수_있다() {
        pathFinder.setStartStation(1, "A")
        assertEquals("A", pathFinder.startStation.title)
    }

    @Test(expected = NoSuchElementException::class)
    fun _시작역이_없으면_예외_발생() {
        pathFinder.setStartStation(100, "FOOBAR")
    }

    @Test
    fun _목적지를_지정할_수_있다() {
        pathFinder.setDestinationStation(2, "C")
        assertEquals("C", pathFinder.destStation.title)
    }

    @Test(expected = NoSuchElementException::class)
    fun _목적지가_없으면_예외_발생() {
        pathFinder.setDestinationStation(100, "FOOBAR")
    }

    @Test
    fun _특정_역이_몇호선인지_찾을_수_있다() {
        assertEquals(2, pathFinder.findOneByStationName("F").lineNumber)
    }

    @Test(expected = NoSuchElementException::class)
    fun _특정_역이_없으면_예외_발생() {
        assertEquals(2, pathFinder.findOneByStationName("FOOBAR").lineNumber)
    }

    @Test
    fun _같은_노선에_있을_때_경로_역들을_반환한다() {
        pathFinder.setStartStation(1, "A")
        pathFinder.setDestinationStation(1, "D")
        assertEquals(4, pathFinder.findPath()?.size)

        pathFinder.setStartStation(2, "C")
        pathFinder.setDestinationStation(2, "F")
        assertEquals(3, pathFinder.findPath()?.size)
    }

    @Test
    fun _다른_노선에_있을_때_환승역을_거쳐_경로_역들을_반환한다() {
        pathFinder.setStartStation(1, "A")
        pathFinder.setDestinationStation(2, "F")
        pathFinder.findPath()?.apply {
            assertTrue(containsAll(listOf(pathFinder.startStation, station(1, "C"), station(2, "C"), pathFinder.destStation)))
        }
    }

    @Test
    fun _환승역을_두_번_거쳐_경로_역들을_반환_할_수_있다() {
        pathFinder.setStartStation(1, "A")
        pathFinder.setDestinationStation(3, "H")
        pathFinder.findPath()?.apply {
            println(this)
            assertTrue(containsAll(listOf(pathFinder.startStation, station(1, "C"), station(2, "C"), station(2, "F"), station(3, "F"), pathFinder.destStation)))
        }
    }

    @Test
    fun _환승역을_세_번_거쳐_경로_역들을_반환_할_수_있다() {
        pathFinder.setStartStation(1, "A")
        pathFinder.setDestinationStation(4, "K")
        pathFinder.findPath()?.apply {
            println(this)
            assertTrue(containsAll(listOf(pathFinder.startStation, station(1, "C"), station(2, "C"), station(2, "F"), station(3, "F"), station(3, "I"), station(4, "I"), pathFinder.destStation)))
        }
    }

    @Test
    fun _시작_경로에_환승역이_여러개_있는_경우_여러_경로를_반환_할_수_있다() {
        pathFinder.setStartStation(1, "A")
        pathFinder.setDestinationStation(4, "K")
        pathFinder.findEveryPath()?.apply {
            assertTrue(get(0).containsAll(listOf(pathFinder.startStation, station(1, "C"), station(2, "C"), station(2, "F"), station(3, "F"), station(3, "I"), station(4, "I"), pathFinder.destStation)))
            assertTrue(get(1).containsAll(listOf(pathFinder.startStation, station(1, "C"), station(1, "Z"), station(4, "Z"), station(4, "K"), pathFinder.destStation)))
        }
    }

    fun station(lineNumber: Int, stationName: String) = pathFinder.findStationByStationName(lineNumber, stationName)

}