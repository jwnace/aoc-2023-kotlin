package day02

import java.io.File

const val RED_CUBES = 12
const val GREEN_CUBES = 13
const val BLUE_CUBES = 14

val input = File("src/main/kotlin/day02/input.txt").readLines()

fun part1() = solve1(input)

fun part2() = solve2(input)

fun solve1(input: List<String>): Int =
    input.map { line -> Game.parse(line) }
        .filter { it.isPossible }
        .sumOf { it.id }

fun solve2(input: List<String>): Int =
    input.map { Game.parse(it) }
        .sumOf { it.power }
