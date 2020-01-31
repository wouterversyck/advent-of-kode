package be.wouterversyck.day4

fun main() = run()

fun run() {
    println(
        calculateWithRange(387638, 919123, and(::test2DigitsRule, ::testNeverDecreaseRule)))
    println(
        calculateWithRange(387638, 919123,
            and(::test2DigitsRuleNotGroupedForIncreasingNumbers, ::testNeverDecreaseRule)))
}

