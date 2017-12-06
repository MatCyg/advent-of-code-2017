package com.mc

fun main(args: Array<String>) {
    val input = Thread.currentThread().contextClassLoader.getResource("input.txt").readText()
    val instructions = input.split(System.lineSeparator())
            .map { it.toInt() }
    println(calculateNoInstructionToExit(instructions))
}


fun calculateNoInstructionToExit(instructions: List<Int>): Int {
    val mutableInstructions = instructions.toMutableList()

    var numberOfSteps = 0
    var pointerPosition = 0
    while (pointerPosition < instructions.size) {
        val instructionUnderPointer = mutableInstructions[pointerPosition]
        mutableInstructions[pointerPosition] = instructionUnderPointer + 1
        pointerPosition += instructionUnderPointer
        numberOfSteps++
    }
    return numberOfSteps
}