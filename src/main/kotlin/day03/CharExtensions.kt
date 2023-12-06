package day03

fun Char.isSymbol() = !this.isDigit() && this != '.'
