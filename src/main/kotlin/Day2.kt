fun calculateChecksum(spreadsheet: List<List<Int>>): Int {
    return spreadsheet
            .map { list -> list.findMinMax() }
            .map(MinMax::calculateDifference)
            .sum()
}

fun List<Int>.findMinMax(): MinMax {
    if (this.isEmpty()) {
        return MinMax(0, 0)
    }
    return MinMax(this.min()!!, this.max()!!)
}

data class MinMax(val minValue: Int, val maxValue: Int) {
    fun calculateDifference() = maxValue - minValue
}

