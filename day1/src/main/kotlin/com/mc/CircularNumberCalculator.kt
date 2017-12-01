package com.mc

class CircularNumberCalculator {
    fun calculate(numbersToAdd: String): Int {
        val lastNumber = numbersToAdd.last().toString().toInt()
        return recursiveAdd(numbersToAdd, lastNumber)
    }

    fun recursiveAdd(numbersLeftToAdd: String, previousNumber: Int): Int {
        if (numbersLeftToAdd.isEmpty()) {
            return 0
        }
        val currentNumber = numbersLeftToAdd.first().toString().toInt()
        val currentResult = if (currentNumber == previousNumber) {
            currentNumber
        } else {
            0
        }
        return currentResult + recursiveAdd(numbersLeftToAdd.substring(1), currentNumber)
    }

}