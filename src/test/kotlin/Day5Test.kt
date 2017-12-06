import org.junit.Test
import kotlin.test.assertEquals


class Day5Test {

    @Test
    internal fun `0 3  0  1  -3 should exit in 5 steps`() {
        val instructios: List<Int> = listOf(0, 3, 0, 1, -3)
        assertEquals(5, calculateNoInstructionToExit(instructios))
    }


}
