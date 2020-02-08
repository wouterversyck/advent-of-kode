package be.wouterversyck.day4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CalculatePasswordsTest {
    val neverDecreaseAnd = andCurry(::testNeverDecreaseRule)

    private val rulesFirstStar = neverDecreaseAnd(::test2DigitsRule)
    private val rulesSecondStarWithWeird2DigitTest
            = neverDecreaseAnd(::test2DigitsRuleNotGroupedForIncreasingNumbers)
    private val rulesSecondStar = neverDecreaseAnd(::test2DigitsNotGroupedRule)

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

    @Test
    fun testOrCurryFunction() {
        assertFalse { orCurry { false }() { false }(5) }
        assertTrue { orCurry { false }() { true }(5) }
        assertTrue { orCurry { true }() { false }(5) }
        assertTrue { orCurry { true }() { true }(5) }
    }

    @Test
    fun testAndCurryFunction() {
        assertFalse { andCurry { false }() { false }(5) }
        assertFalse { andCurry { false }() { true }(5) }
        assertFalse { andCurry { true }() { false }(5) }
        assertTrue { andCurry { true }() { true }(5) }
    }
}
