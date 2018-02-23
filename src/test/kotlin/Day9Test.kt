import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class Day9Test {

    private fun doTest(stream: String, expecteScore: Int) {
        assertEquals(expecteScore, processStream(stream))
    }

    @Test
    fun `{} score of 1`() {
        doTest("{}", 1)
    }

    @Test
    fun `{{{}}} score of 6`() {
        doTest("{{{}}}", 6)
    }

    @Test
    fun `{{},{}}, score of 5`() {
        doTest("{{},{}}", 5)
    }

    @Test
    fun `{{{},{},{{}}}}, score of 16`() {
        doTest("{{{},{},{{}}}}", 16)
    }

    @Test
    fun `{a,a,a,a} score of 1`() {
        doTest("{<a>,<a>,<a>,<a>}", 1)
    }

    @Test
    fun `{{ab},{ab},{ab},{ab}}, score of  9`() {
        doTest("{{<ab>},{<ab>},{<ab>},{<ab>}}", 9)
    }

    @Test
    fun `{{!!},{!!},{!!},{!!}}, score of  9`() {
        doTest("{{<!!>},{<!!>},{<!!>},{<!!>}}", 9)
    }

    @Test
    fun `{{a!},{a!},{a!},{ab}}, score of  3`() {
        doTest("{{<a!>},{<a!>},{<a!>},{<ab>}}", 3)
    }
}