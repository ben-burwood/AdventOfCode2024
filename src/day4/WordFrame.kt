package day4


typealias WordLine = Array<Char>
typealias WordFrame = Array<WordLine>

fun String.toWordFrame(): WordFrame {
    return this.split("\n").map { it.trim() }.filter { it.isNotEmpty() }
        .map { row -> row.toCharArray().toTypedArray() }.toTypedArray()
}

val WordFrame.rows: Iterator<WordLine>
    get() = this.iterator()

val WordFrame.columns: Iterator<WordLine>
    get() = this.transpose().iterator()

val WordFrame.diagonals: Iterator<WordLine>
    get() = this.diagonals().iterator()