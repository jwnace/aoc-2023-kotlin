package day03

data class PartNumber(val number: Int, val row: Int, val startCol: Int, val endCol: Int) {
    fun isAdjacentToSymbol(grid: Map<Pair<Int, Int>, Char>) =
        grid.filter { it.value.isSymbol() }
            .any { isAdjacentTo(it.key) }

    fun isAdjacentTo(position: Pair<Int, Int>) =
        row >= position.first - 1 &&
                row <= position.first + 1 &&
                endCol >= position.second - 1 &&
                startCol <= position.second + 1
}
