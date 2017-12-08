import org.junit.Assert.*
import org.junit.Test

class Day8Test {

    @Test
    fun `highest registry value should be 1`() {
        val instructions = listOf(
            "b inc 5 if a > 1",
            "a inc 1 if b < 5",
            "c dec -10 if a >= 1",
            "c inc -20 if c == 10"
        )

        assertEquals(1, executeCommands(instructions))
    }
}