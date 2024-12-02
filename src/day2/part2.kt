package day2


/** Check if the Report is Safe with Problem Dampener
 * Allowing Removal of a Single Bad Level
 * Yes I Know this is Inefficient, yes it'll do... */
private fun List<Int>.isSafeWithProblemDampener(): Boolean {
    repeat(this.size) { index ->
        val isSafe = this.toMutableList().apply { removeAt(index) }.toList().isSafe()
        if (isSafe) return true
    }
    return false
}


fun main() {
    val reports = readReportsFromFile("src/Day2/Reports.txt")

    println(reports.count { it.isSafeWithProblemDampener() })
}