import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {

    @Test
    fun `{0, 2, 7, 0} should finish in 5 cycles`() {
        val actual = MemoryRelocation().countMemoryRelocationCycles(listOf(0, 2, 7, 0))
        assertEquals(5, actual)
    }
}