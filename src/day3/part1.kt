package day3

import java.io.File


val MUL_REGEX = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()


fun captureUncorruptedMultiplications(input: String): List<Pair<Int, Int>> {
    return MUL_REGEX.findAll(input).map { match ->
        match.groupValues
            .drop(1)
            .map { it.toInt() }
            .let { (it[0] to it[1]) }
    }.toList()
}


fun main() {
    val corruptedMemoryBlock = File("src/day3/CorruptMemory.txt").readText()
    val multiplications = captureUncorruptedMultiplications(corruptedMemoryBlock)
    println(multiplications.sumOf { it.first * it.second })
}