package day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Tests {
    @Test
    fun `part1 example`() {
        // arrange
        val input = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
        )

        // act
        val actual = part1(input)

        // assert
        assertEquals(4361, actual)
    }

    @Test
    fun `part1 solution`() {
        assertEquals(514969, solve1())
    }

    @Test
    fun `part2 example`() {
        // arrange
        val input = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
        )

        // act
        val actual = part2(input)

        // assert
        assertEquals(467835, actual)
    }

    @Test
    fun `part2 solution`() {
        assertEquals(78915902, solve2())
    }
}
