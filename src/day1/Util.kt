package day1

import java.io.File


fun readListsFromFile(fileName: String): Pair<List<Int>, List<Int>> {
    val fileContent = File(fileName).readText()

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    for (line in fileContent.lines()) {
        if (line.isBlank()) continue

        val columns = line.split("   ")
        list1.add(columns[0].trim().toInt())
        list2.add(columns[1].trim().toInt())
    }
    return Pair(list1, list2)
}