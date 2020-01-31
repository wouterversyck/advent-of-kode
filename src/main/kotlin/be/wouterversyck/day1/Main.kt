package be.wouterversyck.day1

import java.io.File

fun main() {
    println(firstStar())
    println(secondStar())
}

fun firstStar() = calculateForList(
        File("""C:\Projects\adventofkode\src\main\resources\calculatefuel.csv""")
        .readLines())

fun secondStar() = calculateForListRecursively(
    File("""C:\Projects\adventofkode\src\main\resources\calculatefuel.csv""")
    .readLines())
