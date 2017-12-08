internal enum class ComparisonOperation(
        val shortName: String,
        val function: (Int, Int) -> Boolean
) {
    LESS_THEN            ("<",  { a: Int, b: Int -> a < b }),
    GREATER_THEN         (">",  { a: Int, b: Int -> a > b }),
    LESS_THEN_OR_EQUAL   ("<=", { a: Int, b: Int -> a <= b }),
    GREATER_THEN_OR_EQUAL(">=", { a: Int, b: Int -> a >= b }),
    EQUALITY             ("==", { a: Int, b: Int -> a == b }),
    INEQUALITY           ("!=", { a: Int, b: Int -> a != b });

    companion object {
        fun fromShortName(shortName: String): ComparisonOperation {
            return values().find { value -> value.shortName == shortName }
                    ?: throw IllegalArgumentException()
        }
    }
}

internal enum class ArithmeticOperation(
        val shortName: String,
        val function: (Int, Int) -> Int
) {
    INC("inc", { a: Int, b: Int -> a + b }),
    DEC("dec", { a: Int, b: Int -> a - b });

    companion object {
        fun fromShortName(shortName: String): ArithmeticOperation {
            return values().find { value -> value.shortName == shortName }
                    ?: throw IllegalArgumentException()
        }
    }

}

internal data class Instruction(
        val operationRegistry: String,
        val operation: ArithmeticOperation,
        val operationNumber: Int,
        val conditionRegistry: String,
        val conditionOperation: ComparisonOperation,
        val conditionNumber: Int
) {
    fun checkCondition(number: Int): Boolean = conditionOperation.function(number, conditionNumber)
    fun executeCommand(number: Int): Int = operation.function(number, operationNumber)


}

fun executeCommands(operations: List<String>): Int {
    val registry = mutableMapOf<String, Int>()
    operations
            .map { operationText ->
                operationText.split(Regex("\\s")).let {
                    Instruction(it[0], ArithmeticOperation.fromShortName(it[1]), it[2].toInt(),
                                it[4], ComparisonOperation.fromShortName(it[5]), it[6].toInt()) }}
            .forEach { instruction ->
                val conditionRegistry = registry[instruction.conditionRegistry] ?: 0
                if (instruction.checkCondition(conditionRegistry)) {
                    val operationRegistryValue = registry[instruction.operationRegistry] ?: 0
                    registry[instruction.operationRegistry] = instruction.executeCommand(operationRegistryValue)
                }
            }
    return registry.maxBy { entry -> entry.value }?.value ?: throw RuntimeException()
}

fun main(args: Array<String>) {
    println(executeCommands("Day8.txt".resourceAsText().split("\n")))
}