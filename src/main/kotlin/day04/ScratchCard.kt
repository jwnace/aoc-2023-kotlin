package day04

import kotlin.math.pow

class ScratchCard(val cardNumber: Int, winningNumbersList: Set<Int>, numbersYouHaveList: Set<Int>) {
    companion object {
        fun parse(line: String): ScratchCard {
            val (left, right) = line.split(": ")
            val cardNumber = left.substring(5).trim().toInt()
            val (winningNumbers, numbersYouHave) = right.split(" | ").map { numbers ->
                numbers.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toSet()
            }

            return ScratchCard(cardNumber, winningNumbers, numbersYouHave)
        }
    }

    val winCount = winningNumbersList.intersect(numbersYouHaveList).count()

    val score = (2.0).pow((winCount - 1).toDouble()).toInt()
}
