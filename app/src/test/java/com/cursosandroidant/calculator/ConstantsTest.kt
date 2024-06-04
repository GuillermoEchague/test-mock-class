package com.cursosandroidant.calculator



import org.junit.Assert.*
import org.junit.Test

class ConstantsTest{
    @Test
    fun testOperatorMulti(){
        assertEquals("x", Constants.OPERATOR_MULTI)
    }


    @Test
    fun testOperatorLess(){
        assertEquals("-", Constants.OPERATOR_SUB)
    }

}