package day4


/** Transpose an Array of Arrays (of Generic Type) such that Columns<->Rows */
inline fun <reified T> Array<Array<T>>.transpose(): Array<Array<T>> {
    val numRows = this.size
    val numColumns = this[0].size
    return Array(numColumns) { j ->
        Array(numRows) { i ->
            this[i][j]
        }
    }
}


/** Get the Diagonals of an Array of Arrays (of Generic Type) */
inline fun <reified T> Array<Array<T>>.diagonals(): List<Array<T>> {
    val diagonals = mutableListOf<Array<T>>()

    val numRows = this.count()
    val numColumns = this[0].count()

    // Forward diagonals (top-left to bottom-right)
    for (i in 0..<numRows) {
        var r = i
        var c = 0
        val diagonal = mutableListOf<T>()
        while (r < numRows && c < numColumns) {
            diagonal.add(this[r][c])
            r++
            c++
        }
        if (diagonal.isNotEmpty()) {
            diagonals.add(diagonal.toTypedArray())
        }
    }

    // Backward diagonals (top-right to bottom-left)
    for (i in 0..<numRows) {
        var r = i
        var c = numColumns - 1
        val diagonal = mutableListOf<T>()
        while (r < numRows && c >= 0) {
            diagonal.add(this[r][c])
            r++
            c--
        }
        if (diagonal.isNotEmpty()) {
            diagonals.add(diagonal.toTypedArray())
        }
    }

    return diagonals
}