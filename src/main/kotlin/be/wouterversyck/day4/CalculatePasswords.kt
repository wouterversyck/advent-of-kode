package be.wouterversyck.day4

fun calculateWithRange(lowerBound: Int, upperBound: Int, rules: (Int) -> Boolean)
        = (lowerBound..upperBound).filter(rules).count()

fun testNeverDecreaseRule(number: Int): Boolean {
    val asString = number.toString()

    (1 until asString.length).forEach {
        if (asString[it - 1].toInt() > asString[it].toInt()) {
            return false
        }
    }

    return true
}

fun test2DigitsRule(number: Int): Boolean {
    val asString = number.toString()

    (1 until asString.length).forEach {
        if (asString[it -1] == asString[it]) {
            return true
        }
    }

    return false
}

// will only work in combination with increasing numbers
fun test2DigitsRuleNotGroupedForIncreasingNumbers(number: Int): Boolean {
    val asString = number.toString()
    val series = IntArray(10)

    asString.indices.forEach {
        val value = asString[it].toString().toInt()
        series[value]++
    }

    return series.any  { it == 2 }
}

fun test2DigitsNotGroupedRule(number: Int): Boolean {
    val asString = number.toString()

    (1 until asString.length).forEach {
        val currentValue = asString[it]
        if (asString[it -1] == currentValue) {
            if (it == 1) {
                if (asString[it + 1] != currentValue) return true
                return@forEach
            }

            if (it == asString.length - 1) {
                if (asString[it - 2 ] != currentValue) return true
                return@forEach
            }

            if (asString[it + 1] != currentValue && asString[it - 2 ] != currentValue) return true
        }
    }
    return false
}

fun or(a: (Int) -> Boolean, b: (Int) -> Boolean ) = { input: Int -> a(input) || b(input) }
fun and(a: (Int) -> Boolean, b: (Int) -> Boolean ) = { input: Int -> a(input) && b(input) }
fun andCurry(a: (Int) -> Boolean) = { b: (Int) -> Boolean -> {input: Int -> a(input) && b(input) } }
fun orCurry(a: (Int) -> Boolean) = { b: (Int) -> Boolean -> {input: Int -> a(input) || b(input) } }