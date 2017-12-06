fun main(args: Array<String>) {
//    val memoryBank = listOf(4, 1, 15, 12, 0, 9, 9, 5, 5, 8, 7, 3, 14, 5, 12, 3)
    val memoryBank = listOf(10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6)
    println(MemoryRelocation().countMemoryRelocationCycles(memoryBank))
}

class MemoryRelocation {

    fun countMemoryRelocationCycles(memoryBank: List<Int>): Int {
        if (memoryBank.isEmpty()) return 0

        val previousBankStates = mutableSetOf<List<Int>>()
        var currentMemoryBank = memoryBank
        while (!previousBankStates.contains(currentMemoryBank)) {
            previousBankStates.add(currentMemoryBank)
            val maxElement = currentMemoryBank.max()!!
            val indexOfMaxValue = currentMemoryBank.indexOfFirst { it == maxElement }

            val mutableBank = currentMemoryBank.toMutableList()
            mutableBank[indexOfMaxValue] = 0
            (0 until maxElement).forEach { index ->
                val indexToEdit = (indexOfMaxValue + 1 + index) % memoryBank.size
                mutableBank[indexToEdit] += 1
            }
            currentMemoryBank = mutableBank
        }

        return previousBankStates.size
    }
}