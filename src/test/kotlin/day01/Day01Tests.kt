package day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Tests {
    @Test
    fun `part1 example`() {
        // arrange
        val input = listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        )

        // act
        val actual = solve1(input)

        // assert
        assertEquals(142, actual)
    }

    @Test
    fun `part1 solution`() {
        assertEquals(55208, part1())
    }

    @Test
    fun `part2 example`() {
        // arrange
        val input = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        )

        // act
        val actual = solve2(input)

        // assert
        assertEquals(281, actual)
    }

    @Test
    fun `part2 solution`() {
        assertEquals(54578, part2())
    }
}
