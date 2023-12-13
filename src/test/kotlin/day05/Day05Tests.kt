package day05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Tests {
    @Test
    fun `part1 example`() {
        // arrange
        val input =
            """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
            """.trimIndent()

        // act
        val actual = solve1(input)

        // assert
        assertEquals(35, actual)
    }

    @Test
    fun `part1 solution`() {
        assertEquals(600279879, part1())
    }

    @Test
    fun `part2 example`() {
        // arrange
        val input =
            """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
            """.trimIndent()

        // act
        val actual = solve2(input)

        // assert
        assertEquals(46, actual)
    }

    @Test
    fun `part2 solution`() {
        assertEquals(20191102, part2())
    }
}
