package day05

data class Mapping(val destinationStart: Long, val sourceStart: Long, val length: Long) {
    val sourceEnd = sourceStart + length
}
