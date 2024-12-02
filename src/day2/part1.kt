package day2

import kotlin.math.abs


enum class ListGradient {
    INCREASING, DECREASING;

    companion object {
        fun get(prevValue: Int, currentValue: Int) = if (currentValue > prevValue) INCREASING else DECREASING
    }
}


/** Check if the Report is Safe:
 * - The levels are either all increasing or all decreasing
 * - Any two adjacent levels differ by at least one and at most three */
fun List<Int>.isSafe(): Boolean {
    var previousGradient: ListGradient? = null
    var previousValue = this.first()

    for ((index, value) in this.withIndex()) {
        if (index == 0) continue

        if (value == previousValue) return false  // Levels Do NOT Differ by at least 1
        if (abs(value - previousValue) > 3) return false  // Levels Differ by Greater than 3

        val currentGradient = ListGradient.get(previousValue, value)
        if (previousGradient != null && currentGradient != previousGradient) return false

        previousGradient = currentGradient
        previousValue = value
    }

    return true
}


fun main() {
    val reports = readReportsFromFile("src/Day2/Reports.txt")

    println(reports.count { it.isSafe() })
}