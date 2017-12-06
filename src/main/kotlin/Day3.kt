import java.lang.Math.abs

fun main(args: Array<String>) {
    print(calculateSpiralaVecotrForNumber(361527))
}

fun calculateSpiralaVecotrForNumber(number: Int): Int {
    val sqrt = Math.sqrt(number.toDouble())
    val squareRoot = Math.ceil(sqrt).toInt()
    val isCloserToEvenSquare = squareRoot.isEven()

    val ringLength = if (isCloserToEvenSquare) {
        squareRoot + 1
    } else {
        squareRoot
    }
    val distanceFromMiddle = (ringLength - 1) / 2

    val squareValueOffset = (squareRoot + 1) % 2
    val square = squareRoot * squareRoot
    val corner = square + squareValueOffset - ringLength
    return if (number > corner) {
        val x = distanceFromMiddle - squareValueOffset - abs(square - number)
        val y = distanceFromMiddle
        x + y
    } else {
        val x = distanceFromMiddle
        val y = distanceFromMiddle - squareValueOffset - (corner - number)
        x + y
    }
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}