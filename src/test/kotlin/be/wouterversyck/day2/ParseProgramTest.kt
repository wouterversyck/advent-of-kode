package be.wouterversyck.day2

import org.junit.Test
import kotlin.test.assertEquals


internal class ParseProgramTest {
    @Test
    fun testParseProgram() {
        assertEquals(
            listOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50),
            executeAndContinue(listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50).toMutableList()))
        assertEquals(
            listOf(2, 0, 0, 0, 99),
            executeAndContinue(listOf(1, 0, 0, 0, 99).toMutableList()))
        assertEquals(
            listOf(2, 3, 0, 6, 99),
            executeAndContinue(listOf(2, 3, 0, 3, 99).toMutableList()))
        assertEquals(
            listOf(2, 4, 4, 5, 99, 9801),
            executeAndContinue(listOf(2, 4, 4, 5, 99, 0).toMutableList()))
        assertEquals(
            listOf(30, 1, 1, 4, 2, 5, 6, 0, 99),
            executeAndContinue(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99).toMutableList()))
    }

    @Test
    fun testFindNounAndVerbFor() {
        val (noun, verb) = findNounAndVerbFor(loadIntegers("""C:\Projects\adventofkode\src\main\resources\program.csv"""), 19690720)
        assertEquals(6718, 100 * noun + verb)
    }

}
