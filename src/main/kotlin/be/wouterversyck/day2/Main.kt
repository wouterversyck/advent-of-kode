package be.wouterversyck.day2

fun main() {
    partOne()
    partTwo(19690720)
}

fun partOne() {
    val integers = loadIntegers("""C:\Projects\adventofkode\src\main\resources\program.csv""")

    integers[1] = 12
    integers[2] = 2
    println(
        executeAndContinue(integers)
    )
}

fun partTwo(find: Int) {
    val (noun, verb) = findNounAndVerbFor(loadIntegers("""C:\Projects\adventofkode\src\main\resources\program.csv"""), find)
    println("found result for $find: ${100 * noun + verb}")
}


