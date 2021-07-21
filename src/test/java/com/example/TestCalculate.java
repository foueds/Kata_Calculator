package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestCalculate {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void emptyStringReturnZero() throws Exception {
        assertEquals(calculator.calculate(""), 0);
    }

    @Test
    public void singleValueIsReplied() throws Exception {
        assertEquals(calculator.calculate("1"), 1);
    }

    @Test
    public void twoNumberCommaDelimitReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2"), 3);
    }

    @Test
    public void twoNumberNewLineDelimitReturnSum() throws Exception {
        assertEquals(calculator.calculate("1\n2"), 3);
    }

    @Test
    public void threeNumberNewLineDelimitReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,2,3"), 6);
    }

    @Test
    public void negativeInputReturnException() {
        assertThrows(Exception.class, () -> calculator.calculate("-1"));
    }

    @Test
    public void ignoreNumbergreaterThan1000() throws Exception {
        assertEquals(calculator.calculate("100,2,1000"), 102);
    }
}
