package com.guvi.travisciguvi

import junit.framework.TestCase.assertEquals
import org.junit.Test

class BmiCalculatorTest {

    @Test
    fun testBmi(){
        val personWeightInKg = 87.6
        val personHeightInMeters = 1.75
        val result = BmiCalculator().calculateBmi(weightInKg = personWeightInKg, heightInMeters = personHeightInMeters )
        val formattedString = String.format("%.2f", result.first)
        assertEquals("28.60", formattedString)
        assertEquals(BmiEnum.OVER_WEIGHT, result.second)
    }
}