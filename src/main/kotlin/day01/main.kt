package day01

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day01/input.txt").readLines()

    val digitStrings = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )

    fun part1(): Int =
        input.map { line -> line.filter { c -> c.isDigit() } }
            .sumOf { "${it.first()}${it.last()}".toInt() }

    fun part2(): Int {
        var sum = 0

        for (line in input) {
            val digits = mutableListOf<Int>()

            for (i in line.indices) {
                val c = line[i]

                if (c.isDigit()) {
                    digits.add(c.digitToInt())
                    continue
                }

                for (d in digitStrings.keys) {
                    if (line.substring(i).startsWith(d)) {
                        digits.add(digitStrings[d]!!)
                        break
                    }
                }
            }

            sum += digits.first() * 10 + digits.last()
        }

        return sum
    }

    println("Day 01, Part 1: ${part1()}")
    println("Day 01, Part 2: ${part2()}")
}
