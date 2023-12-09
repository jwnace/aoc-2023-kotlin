package day02

import java.io.File

const val RED_CUBES = 12
const val GREEN_CUBES = 13
const val BLUE_CUBES = 14

val input = File("src/main/kotlin/day02/input.txt").readLines()

fun solve1() = part1(input)

fun solve2() = part2(input)

fun part1(input: List<String>): Int =
    input.map { line -> Game.parse(line) }
        .filter { it.isPossible }
        .sumOf { it.id }

fun part2(input: List<String>): Int =
    input.map { Game.parse(it) }
        .sumOf { it.power }
