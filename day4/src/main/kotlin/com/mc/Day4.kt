package com.mc



fun main(args: Array<String>) {
    val fileTxt = Thread.currentThread().contextClassLoader.getResource("passphrase.txt").readText()
    val numberOfValidPasphrases = fileTxt.split(System.lineSeparator())
            .map { passphrase -> isPassphraseValid(passphrase) }
            .filter { isValid -> isValid }
            .count()
    println(numberOfValidPasphrases)
}


fun isPassphraseValid(passphrase: String): Boolean {
    val split = passphrase.split("\\s+".toRegex())
    return split.toSet().size == split.size
}


