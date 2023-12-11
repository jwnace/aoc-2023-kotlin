package day04

import java.io.File

val input = File("src/main/kotlin/day04/input.txt").readLines()

fun part1() = solve1(input)

fun part2() = solve2(input)

fun solve1(input: List<String>): Int = input.map { ScratchCard.parse(it) }.sumOf { it.score }

fun solve2(input: List<String>): Int {
    val cards = input.map { ScratchCard.parse(it) }
    val cardCounts = cards.associate { it.cardNumber to 1 }.toMutableMap()
    val minCardNumber = cards.minOf { it.cardNumber }
    val maxCardNumber = cards.maxOf { it.cardNumber }

    for (cardNumber in minCardNumber..maxCardNumber) {
        val card = cards.find { it.cardNumber == cardNumber } ?: continue
        val cardCount = cardCounts[cardNumber] ?: continue

        for (j in 1..card.winCount) {
            cardCounts[cardNumber + j] = cardCounts[cardNumber + j]!! + cardCount
        }
    }

    return cardCounts.values.sum()
}
