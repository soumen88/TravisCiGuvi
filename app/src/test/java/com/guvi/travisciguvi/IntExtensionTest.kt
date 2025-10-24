package com.guvi.travisciguvi

import com.guvi.travisciguvi.extensions.isEven
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class IntExtensionTest {
    @Test
    fun testIfNumberIsEven(){
        assertTrue(4.isEven())
        assertFalse(7.isEven())
    }
}