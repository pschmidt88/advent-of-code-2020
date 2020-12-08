import java.io.File

class Day2 {
    private val input = File("input/day2.txt").readLines()
    private var validPasswords = 0

    fun challenge1() {
        for (line in input) {
            val passwordPolicy = PasswordPolicy(line.substringBefore(":"))
            val password = line.substringAfterLast(": ")

            when(password.count { it == passwordPolicy.allowedCharacter }) {
                in passwordPolicy.range -> validPasswords++
            }
        }

        println("$validPasswords valid password")
    }

    fun challenge2() {
        for (line in input) {
            val passwordPolicy = PasswordPolicy(line.substringBefore(":"))
            val password = line.substringAfterLast(": ")

            if ((password[passwordPolicy.position1] == passwordPolicy.allowedCharacter) xor
                (password[passwordPolicy.position2] == passwordPolicy.allowedCharacter)) {
                validPasswords++
            }
        }

        println("$validPasswords valid password")
    }
}

class PasswordPolicy(value: String) {
    private val numbers = value.substringBefore(" ").split("-")
    val allowedCharacter = value.substringAfter(" ").single()
    val position1 = numbers[0].toInt() - 1
    val position2 = numbers[1].toInt() - 1
    val range: IntRange = numbers[0].toInt()..numbers[1].toInt()
}
