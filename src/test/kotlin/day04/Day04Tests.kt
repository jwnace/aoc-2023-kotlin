package day04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Tests {
    @Test
    fun `part1 example`() {
        // arrange
        val input = listOf(
            "",
        )

        // act
        val actual = part1(input)

        // assert
        assertEquals(0, actual)
    }

    @Test
    fun `part1 solution`() {
        assertEquals(0, solve1())
    }

    @Test
    fun `part2 example`() {
        // arrange
        val input = listOf(
            "",
        )

        // act
        val actual = part2(input)

        // assert
        assertEquals(0, actual)
    }

    @Test
    fun `part2 solution`() {
        assertEquals(0, solve2())
    }
}
