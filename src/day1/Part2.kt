package day1


private fun listCheck(list1: List<Int>, list2: List<Int>): Int {
    var similarity = 0
    list1.forEach { list1Number ->
        val similarityCount = list2.count { list2Number ->
            list2Number == list1Number
        }

        val currentSimilarity = list1Number * similarityCount
        similarity += currentSimilarity
    }
    return similarity
}


fun main() {
    val (list1, list2) = readListsFromFile("src/Day1/Locations.txt")
    println(listCheck(list1, list2))
}