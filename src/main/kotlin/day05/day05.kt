package day05

import java.io.File

val input = File("src/main/kotlin/day05/input.txt").readText()

fun part1() = solve1(input)

fun part2() = solve2(input)

fun solve1(input: String): Long {
    var (seeds, mappingFunctions) = parseInput(input)

    for (mappingFunction in mappingFunctions) {
        seeds = mappingFunction.mapValues(seeds)
    }

    return seeds.min()
}

fun solve2(input: String): Long {
    val (seeds, mappingFunctions) = parseInput(input)
    val seedRanges = seeds.chunked(2).map { SeedRange(it[0], it[0] + it[1]) }
    val resultRanges = mutableListOf<SeedRange>()

    for (seedRange in seedRanges) {
        var newRanges = listOf(SeedRange(seedRange.start, seedRange.end))

        for (mappingFunction in mappingFunctions) {
            newRanges = mappingFunction.mapRanges(newRanges)
        }

        resultRanges.add(newRanges.minBy { it.start })
    }

    return resultRanges.minOf { it.start }
}

fun parseInput(input: String): Pair<List<Long>, List<MappingFunction>> {
    val sections = input.split("\n\n").filter { it.isNotEmpty() }
    val seeds = sections[0].split(" ").drop(1).map { it.toLong() }
    val mappingFunctions = sections.drop(1).filter { it.isNotEmpty() }.map { MappingFunction.parse(it) }

    return Pair(seeds, mappingFunctions)
}
