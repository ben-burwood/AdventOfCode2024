package day5


data class PageOrderingRule(
    val early: Int,
    val late: Int
) {
    val list: List<Int>
        get() = listOf(this.early, this.late)

    companion object {
        fun String.toPageOrderingRule(): PageOrderingRule {
            val rule = this.split("|")
            return PageOrderingRule(early = rule[0].trim().toInt(), late = rule[1].trim().toInt())
        }
    }
}
