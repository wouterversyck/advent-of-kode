package be.wouterversyck.day2

import java.lang.IllegalArgumentException

fun findNounAndVerbFor(program: List<Int>, find: Int): Pair<Int, Int> {
    (0..99).forEach { noun ->
        (0..99).forEach { verb ->
            val integers = program.toMutableList()
            integers[1] = noun
            integers[2] = verb
            val result = executeAndContinue(integers)[0]
            if (result == find) {
               return Pair(noun,  verb)
            }
        }
    }
    throw IllegalArgumentException("Does not compute")
}

fun executeAndContinue(program: MutableList<Int>, index: Int = 0): List<Int> {
    when(program[index]) {
        1 -> action(program, index) { a, b -> a + b }
        2 -> action(program, index) { a, b -> a * b }
        99 -> return program
        else -> throw IllegalArgumentException("OpCode not supported")
    }

    return program
}

private fun action(program: MutableList<Int>, index: Int, action: (Int, Int) -> Int) {
    val result = action(getValueAtIndex(program, index + 1),  getValueAtIndex(program, index + 2))
    program[program[index + 3]] = result
    executeAndContinue(program, index + 4)
}

private fun getValueAtIndex(program: MutableList<Int>, index: Int) = program[program[index]]
