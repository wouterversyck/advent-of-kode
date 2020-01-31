package be.wouterversyck.day4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CalculatePasswordsTest {
    private val rulesFirstStar = and(::test2DigitsRule, ::testNeverDecreaseRule)
    private val rulesSecondStarWithWeird2DigitTest
            = and(::test2DigitsRuleNotGroupedForIncreasingNumbers, ::testNeverDecreaseRule)
    private val rulesSecondStar = and(::test2DigitsNotGroupedRule, ::testNeverDecreaseRule)

    @Test
    fun testFirstStar() {
        assertEquals(466, calculateWithRange(387638, 919123, rulesFirstStar))
    }

    @Test
    fun testSecondStar() {
        assertEquals(292,
            calculateWithRange(387638, 919123, rulesSecondStar))
    }

    @Test
    fun testSecondStarWithWeird2DigitsTest() {
        assertEquals(292,
            calculateWithRange(387638, 919123, rulesSecondStarWithWeird2DigitTest))
    }

    @Test
    fun testSingleValuesFirstStar() {
        assertTrue { rulesFirstStar(111111) }
        assertFalse { rulesFirstStar(223450) }
        assertFalse { rulesFirstStar(123789) }
    }

    @Test
    fun testSingleValuesSecondStar() {
        assertTrue { rulesSecondStar(112233) }
        assertFalse { rulesSecondStar(123444) }
        assertTrue { rulesSecondStar(111122) }
    }

    @Test
    fun testOrHigherOrderFunction() {
        assertFalse { or({ false }, { false })(5) }
        assertTrue { or({ false }, { true })(5) }
        assertTrue { or({ true }, { false })(5) }
        assertTrue { or({ true }, { true })(5) }
    }

    @Test
    fun testAndHigherOrderFunction() {
        assertFalse { and({ false }, { false })(5) }
        assertFalse { and({ false }, { true })(5) }
        assertFalse { and({ true }, { false })(5) }
        assertTrue { and({ true }, { true })(5) }
    }
}
