package day4

import java.io.File


const val WORD_TO_FIND = "XMAS"


/* Check if the given WordLine - i.e. an Extracted Column/Row/Diagonal - contains the Word to be Found
*   This function will check for the Word in Either Direction and return a Count of How Many Times it Appeared */
private fun WordLine.contains(word: String): Int {
    val wordLength = word.length
    val wordString = String(this.toCharArray())

    var count = 0
    var index = 0

    while (index < wordString.length - wordLength + 1) {
        val substring = wordString.substring(index, index + wordLength)
        if (substring == word || substring.reversed() == word) {
            count++
            // Check for overlaps by moving the index forward by one less than the word length
            index += wordLength - 1
        } else {
            index++
        }
    }

    return count
}


private fun wordSearch(wordFrame: WordFrame, wordToFind: String): Int {
    var sum = 0
    for (row in wordFrame.rows) {
        sum += row.contains(wordToFind)
    }
    for (column in wordFrame.columns) {
        sum += column.contains(wordToFind)
    }
    for (diagonal in wordFrame.diagonals) {
        sum += diagonal.contains(wordToFind)
    }
    return sum
}

fun main() {
    val wordFrame = File("src/day4/WordSearch.txt").readText().toWordFrame()
    println(wordSearch(testFrame, WORD_TO_FIND))
}