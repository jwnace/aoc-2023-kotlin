package day02

data class Game(val id: Int, val rounds: List<Round>) {
    companion object {
        fun parse(input: String): Game {
            val (left, right) = input.split(": ")
            val id = left.split(" ")[1].trimEnd(':').toInt()
            val rounds = right.split("; ").map { Round.parse(it) }

            return Game(id, rounds)
        }
    }

    private val minRed = rounds.maxOf { it.red }

    private val minGreen = rounds.maxOf { it.green }

    private val minBlue = rounds.maxOf { it.blue }

    val isPossible = minRed <= RED_CUBES && minGreen <= GREEN_CUBES && minBlue <= BLUE_CUBES

    val power = minRed * minGreen * minBlue
}
