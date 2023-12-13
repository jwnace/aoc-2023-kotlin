package day05

import kotlin.math.max
import kotlin.math.min

class MappingFunction(val mappings: List<Mapping>) {
    companion object {
        fun parse(section: String): MappingFunction {
            val mappings = section.split('\n').filter { it.isNotEmpty() }.drop(1)
                .map { line -> line.split(' ').filter { it.isNotEmpty() }.map { it.toLong() } }
                .map { Mapping(it[0], it[1], it[2]) }

            return MappingFunction(mappings)
        }
    }

    fun mapValues(values: List<Long>): List<Long> {
        return values.map { mapValue(it) }
    }

    private fun mapValue(value: Long): Long {
        for (mapping in mappings) {
            if (mapping.sourceStart <= value && value < mapping.sourceStart + mapping.length) {
                return mapping.destinationStart + value - mapping.sourceStart
            }
        }

        return value
    }

    fun mapRanges(inputRanges: List<SeedRange>): List<SeedRange> {
        var ranges = inputRanges
        val mappedRanges = mutableListOf<SeedRange>()

        for (mapping in mappings) {
            val newRanges = mutableListOf<SeedRange>()

            for (seedRange in ranges) {
                val a = SeedRange(seedRange.start, min(seedRange.end, mapping.sourceStart))
                val b = SeedRange(max(seedRange.start, mapping.sourceStart), min(seedRange.end, mapping.sourceEnd))
                val c = SeedRange(max(seedRange.start, mapping.sourceEnd), seedRange.end)

                if (a.start < a.end) {
                    newRanges.add(a)
                }

                if (b.start < b.end) {
                    mappedRanges.add(
                        SeedRange(
                            b.start - mapping.sourceStart + mapping.destinationStart,
                            b.end - mapping.sourceStart + mapping.destinationStart
                        )
                    )
                }

                if (c.start < c.end) {
                    newRanges.add(c)
                }
            }

            ranges = newRanges
        }

        mappedRanges.addAll(ranges)

        return mappedRanges
    }
}
