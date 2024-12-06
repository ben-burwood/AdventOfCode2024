package day5


typealias SafetyManualUpdate = List<Int>


fun String.toSafetyManualUpdate() = this.split(",").map { it.trim().toInt() }
