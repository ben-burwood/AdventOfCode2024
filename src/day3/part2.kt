package day3

import java.io.File


val DO_REGEX = """do()"""
val DONT_REGEX = """don't()"""


fun captureUncorruptedMultiplicationsWithConditionals(input: String): List<Pair<Int, Int>> {
    return MUL_REGEX.findAll(input).map { match ->
        match.groupValues.let {
            val currentMatch = it[0]
            val mul = (it[1].toInt() to it[2].toInt())

            val leadingString = input.substringBefore(currentMatch)

            val lastDo = leadingString.lastIndexOf(DO_REGEX)
            val lastDont = leadingString.lastIndexOf(DONT_REGEX)

            return@map if (lastDo == -1 && lastDont == -1) mul
            else if (lastDo == -1) null
            else if (lastDont == -1) mul
            else {
                val enabled = lastDo > lastDont

                if (enabled) mul else null
            }
        }
    }.filterNotNull().toList()
}


fun main() {
    val corruptedMemoryBlock = File("src/day3/CorruptMemory.txt").readText()
    val multiplications = captureUncorruptedMultiplicationsWithConditionals(corruptedMemoryBlock)
    println(multiplications.sumOf { it.first * it.second })
}