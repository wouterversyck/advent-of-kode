package be.wouterversyck.day3

import org.junit.Test
import kotlin.test.assertEquals

class PathsCreatorTest {

    @Test
    fun test() {
        val creator = PathsCreator("R2,D3,L4")
        val result = creator.mapPath()

        val expected = setOf(
            Element(1, 0, 1), Element(2, 0, 2),
            Element(2, -1, 3), Element(2, -2, 4),
            Element(2, -3, 5), Element(1, -3, 6),
            Element(0, -3, 7), Element(-1, -3, 8),
            Element(-2, -3, 9))

        assertEquals(expected, result)
    }

}
