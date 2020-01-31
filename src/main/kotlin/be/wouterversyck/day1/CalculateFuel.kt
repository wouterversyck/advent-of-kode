package be.wouterversyck.day1

fun calculateForList(list: List<String>) = calculateWithAction(list, ::calculateFuel)

fun calculateForListRecursively(list: List<String>) = calculateWithAction(list, ::calculateRecursively)

internal fun calculateFuel(mass: Int) = mass / 3 - 2

internal fun calculateRecursively(initial: Int): Int {
        val result = calculateFuel(initial)

        if (result < 1) return 0

        return result + calculateRecursively(result)
}

private fun calculateWithAction(list: List<String>, fileAction: (Int) -> Int): Int {
       return list
               .map { fileAction(it.toInt()) }
               .sum()
}
