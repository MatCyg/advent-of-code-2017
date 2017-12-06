package com.mc

import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {

    private fun doTest(number: Int, expectedResult: Int) {
        val actualResult = calculateSpiralaVecotrForNumber(number)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    internal fun `1 should return 0`() {
        doTest(1, 0)
    }

    @Test
    internal fun `12 should return 3`() {
        doTest(12, 3)
    }

    @Test
    internal fun `23 should return 2`() {
        doTest(23, 2)
    }

    @Test
    internal fun `1024 should return 31`() {
        doTest(1024, 31)
    }

}