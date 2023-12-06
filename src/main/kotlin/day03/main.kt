package day03

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day03/input.txt").readLines()

    fun buildGrid(): Map<Pair<Int, Int>, Char> {
        val grid = mutableMapOf<Pair<Int, Int>, Char>()

        for (row in input.indices) {
            for (col in input[row].indices) {
                grid[Pair(row, col)] = input[row][col]
            }
        }

        return grid
    }

    fun getPartNumbers(grid: Map<Pair<Int, Int>, Char>): List<PartNumber> {
        val partNumbers = mutableListOf<PartNumber>()
        val maxRow = grid.maxOf { it.key.first }
        val maxCol = grid.maxOf { it.key.second }

        for (row in 0..maxRow) {
            var col = 0

            while (col <= maxCol) {
                var currentNumber = 0
                var startCol = 0
                var endCol = 0

                while (grid[Pair(row, col)]?.isDigit() == true) {
                    if (currentNumber == 0) {
                        currentNumber = grid[Pair(row, col)]!!.digitToInt()
                        startCol = col
                        endCol = col
                    } else {
                        currentNumber = currentNumber * 10 + grid[Pair(row, col)]!!.digitToInt()
                        endCol = col
                    }

                    col++
                }

                if (currentNumber != 0) {
                    partNumbers.add(PartNumber(currentNumber, row, startCol, endCol))
                }

                col++
            }
        }

        return partNumbers.filter { it.isAdjacentToSymbol(grid) }
    }

    fun symbolIsAdjacentToTwoPartNumbers(partNumbers: List<PartNumber>, symbol: Map.Entry<Pair<Int, Int>, Char>) =
        partNumbers.count { it.isAdjacentTo(symbol.key) } == 2

    fun getAdjacentPartNumbers(partNumbers: List<PartNumber>, symbol: Map.Entry<Pair<Int, Int>, Char>) =
        partNumbers.filter { it.isAdjacentTo(symbol.key) }

    fun part1(): Int {
        val grid = buildGrid()
        val partNumbers = getPartNumbers(grid)

        return partNumbers.sumOf { it.number }
    }

    fun part2(): Int {
        val grid = buildGrid()
        val partNumbers = getPartNumbers(grid)

        return grid.filter { it.value.isSymbol() }
            .filter { symbol -> symbolIsAdjacentToTwoPartNumbers(partNumbers, symbol) }
            .map { symbol -> getAdjacentPartNumbers(partNumbers, symbol) }
            .sumOf { it[0].number * it[1].number }
    }

    println("Day 03, Part 1: ${part1()}")
    println("Day 03, Part 2: ${part2()}")
}
