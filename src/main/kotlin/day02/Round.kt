package day02

data class Round(val red: Int, val green: Int, val blue: Int) {
    companion object {
        fun parse(input: String): Round {
            var r = 0
            var g = 0
            var b = 0

            val cubes = input.split(", ")
                .map { it.split(" ") }
                .map { (count, color) -> Pair(count.toInt(), color) }

            for ((count, color) in cubes) {
                when (color) {
                    "red" -> r = count
                    "green" -> g = count
                    "blue" -> b = count
                }
            }

            return Round(r, g, b)
        }
    }
}
