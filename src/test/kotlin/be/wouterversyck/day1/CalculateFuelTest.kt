package be.wouterversyck.day1

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CalculateFuelTest {

    @Test
    fun testCalculateFuel() {
        assertEquals(2, calculateFuel(12))
        assertEquals(2, calculateFuel(14))
        assertEquals(654, calculateFuel(1969))
        assertEquals(33583, calculateFuel(100756))
    }

    @Test
    fun testCalculateFuelRecursively() {
        assertEquals(2, calculateRecursively(14))
        assertEquals(966, calculateRecursively(1969))
        assertEquals(50346, calculateRecursively(100756))
    }

}
