import java.io.File

class Day1 {
    private val input = File("input/day1.txt").readLines().map { it.toInt() }

    fun challenge1() {
        for (firstNumber in input) {
            for (secondNumber in input) {
                if (firstNumber + secondNumber == 2020) {
                    println(firstNumber * secondNumber)
                    return
                }
            }
        }
    }

    fun challenge2() {
        for (x1 in input) {
            for (x2 in input) {
                for (x3 in input) {
                    if (x1 + x2 + x3 == 2020) {
                        println("x1 = $x1, x2 = $x2, x3 = $x3")
                        println("== ${x1*x2*x3}")
                        return
                    }
                }
            }
        }
    }
}