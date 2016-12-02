import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 12. 2..
 */

const val DUMMY_ID = "hello"

class LearningStandardLibraryTest {

    @Before
    fun setUp() {
        map.put(DUMMY_ID, Config("DEVELOPMENT", "1.0"))
    }

    @Test
    fun configuration() {
        println(configurationFor(DUMMY_ID)?.apply {
            assertEquals("DEBUG", buildType)
        })
    }

    @Test
    fun configuration2() {
        println(configurationFor(DUMMY_ID)?.run {
            assertEquals("1.2", version)
        })
    }
}