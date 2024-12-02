package day2

import java.io.File


fun readReportsFromFile(fileName: String): List<List<Int>> {
    val fileContent = File(fileName).readLines()

    return fileContent.map { report ->
        report.split(" ").map { level ->
            level.toInt()
        }
    }
}