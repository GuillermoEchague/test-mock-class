package com.cursosandroidant.calculator

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CalculatorUtilsTest {
    // Configuraciones iniciales
    @Mock
    lateinit var operations: Operations

    @Mock
    lateinit var listener: OnResolveListener

    private lateinit var calculatorUtils: CalculatorUtils

    @Before
    fun setup(){
        calculatorUtils = CalculatorUtils(operations, listener)
    }

    @Test
    fun calc_callCheckOrResolve_noRreturn(){
        val operation  = "-5x2.5"
        val isFromResolve  = true
        calculatorUtils.checkOrResolve(operation, isFromResolve)
        verify(operations).tryResolve(operation, isFromResolve, listener)
    }

    @Test
    fun calc_callAddOperator_validSub_noRreturn(){
        val operator  = "-"
        val operation  = "4+"
        var isCorrect = false
        calculatorUtils.addOperator(operator, operation){
            isCorrect = true
        }
        assertTrue(isCorrect)

    }

    @Test
    fun calc_callAddPoint_SecondPoint_noReturns(){
        val operation = "3.5x2"
        val operator="x"
        var isCorrect = false

        `when`(operations.getOperator(operation)).thenReturn("x")
        `when`(operations.divideOperation(operator, operation)).thenReturn(arrayOf("3.5", "2"))

        calculatorUtils.addPoint(operation){
            isCorrect = true
        }


        assertTrue(isCorrect)
        verify(operations).getOperator(operation)
        verify(operations).divideOperation(operator, operation)

    }





}