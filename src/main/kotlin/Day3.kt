import java.io.File

class Day3 {

    private val treeMap = File("input/day3.txt").readLines()

    fun challenge1() {
        var treeCount = 0;
        var rightCounter = 3

        for (line in treeMap.drop(1)) {
            rightCounter %= 31
            if (line[rightCounter] == '#') {
                treeCount++
            }

            rightCounter += 3
        }

        println("$treeCount trees")
    }

    fun challenge2() {
        val countA = countTreesForSlope(1, 1)
        val countB = countTreesForSlope(3, 1)
        val countC = countTreesForSlope(5, 1)
        val countD = countTreesForSlope(7, 1)
        val countE = countTreesForSlope(1, 2)

        println("$countA * $countB * $countC * $countD * $countE")
        println("${countA * countB * countC * countD * countE}")
    }

    private fun countTreesForSlope(right: Int, down: Int): Int {
        var rightCounter = right
        var treeCount = 0

        for ((index, line) in treeMap.drop(down).withIndex()) {
            if (index % down != 0) {
                continue
            }

            rightCounter %= 31
            if (line[rightCounter] == '#') {
                treeCount++
            }

            rightCounter += right
        }

        return treeCount
    }
}