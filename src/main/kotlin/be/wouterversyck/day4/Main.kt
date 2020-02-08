package be.wouterversyck.day4

fun main() = run()

fun run() {

    val neverDecreaseAnd = andCurry(::testNeverDecreaseRule)
    println(
        calculateWithRange(387638, 919123, neverDecreaseAnd(::test2DigitsRule)))
    println(
        calculateWithRange(387638, 919123,
            neverDecreaseAnd(::test2DigitsRuleNotGroupedForIncreasingNumbers)))
}

