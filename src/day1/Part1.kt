package day1

import kotlin.math.abs


private fun listCheck(list1: List<Int>, list2: List<Int>): Int {
    val sortedList1 = list1.sorted()
    val sortedList2 = list2.sorted()

    val differences = mutableListOf<Int>()
    repeat(sortedList1.size) {
        val diff = abs(sortedList1[it] - sortedList2[it])
        differences.add(diff)
    }

    return differences.sum()
}


fun main() {
    val (list1, list2) = readListsFromFile("src/Day1/Locations.txt")
    println(listCheck(list1, list2))
}