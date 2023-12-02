package day02

import java.io.File

const val RED_CUBES = 12
const val GREEN_CUBES = 13
const val BLUE_CUBES = 14

fun main() {
    val input = File("src/main/kotlin/day02/input.txt").readLines()

    fun part1(): Int =
        input.map { line -> Game.parse(line) }
            .filter { it.isPossible }
            .sumOf { it.id }

    fun part2(): Int =
        input.map { Game.parse(it) }
            .sumOf { it.power }

    println("Day 02, Part 1: ${part1()}")
    println("Day 02, Part 2: ${part2()}")
}
