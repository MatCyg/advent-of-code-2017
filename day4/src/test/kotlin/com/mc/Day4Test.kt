package com.mc

import org.junit.Assert.*
import org.junit.Test

class Day4Test {

    private fun doTest(passphrase: String, isValid: Boolean) {
        val actual = isPassphraseValid(passphrase)
        assertEquals(isValid, actual)
    }

    @Test
    internal fun `aa bb cc dd ee passphrase is valid`() {
        doTest("aa bb cc dd ee", true)
    }

    @Test
    internal fun `aa bb cc dd aa passphrase is not valid`() {
        doTest("aa bb cc dd aa", false)
    }

    @Test
    internal fun `aa bb cc dd aaa passphrase is valid`() {
        doTest("aa bb cc dd aaa", true)
    }

}