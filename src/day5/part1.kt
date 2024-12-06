package day5

import day5.PageOrderingRule.Companion.toPageOrderingRule
import java.io.File


fun SafetyManualUpdate.assessUpdateOrder(rules: List<PageOrderingRule>): Boolean {
    val relevantRules = rules.filter { this.containsAll(it.list) }

    relevantRules.forEach {
        val earlyElementIndex = this.indexOf(it.early)
        val lateElementIndex = this.indexOf(it.late)

        // Ensure that the Early Element comes BEFORE the Late Element
        if (earlyElementIndex > lateElementIndex) return false
    }
    return true
}


fun main() {
    val inputText = File("src/day5/SafetyManuals.txt").readText()

    val rules = mutableListOf<PageOrderingRule>()
    val updates = mutableListOf<SafetyManualUpdate>()

    for (line in inputText.split("\n")) {
        if (line.isBlank()) continue

        if (line.contains("|")) rules.add(line.toPageOrderingRule())
        else if (line.contains(",")) updates.add(line.toSafetyManualUpdate())
    }

    val correctUpdates = updates.filter { it.assessUpdateOrder(rules) }

    val middlePageNumbers = correctUpdates.map {
        val middleIndex = it.size / 2
        it.elementAt(middleIndex)
    }
    println(middlePageNumbers.sum())
}