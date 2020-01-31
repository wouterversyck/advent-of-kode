package be.wouterversyck.day4

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CalculatePasswordRulesTest {

    @Test
    fun testDecreasingNumbersRule() {
        assertTrue { testNeverDecreaseRule(112233) }
        assertFalse { testNeverDecreaseRule(112133) }
    }

    @Test
    fun test2DigitsRule() {
        assertTrue { test2DigitsRule(114545) }
        assertTrue { test2DigitsRule(111545) }
        assertFalse { test2DigitsRule(145451) }
    }

    @Test
    fun test2DigitsNotGroupedRule() {
        assertTrue { test2DigitsNotGroupedRule(114545) }
        assertFalse { test2DigitsNotGroupedRule(111545) }
        assertFalse { test2DigitsNotGroupedRule(111145) }
        assertFalse { test2DigitsNotGroupedRule(111111) }
        assertFalse { test2DigitsNotGroupedRule(145451) }
    }
}
