package ruskypro.calculator22.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ruskypro.calculator22.exception.ZeroDivideException;

import static org.junit.jupiter.api.Assertions.*;
import static ruskypro.calculator22.service.CalculatorTestConstants.*;


class CalculatorServiceImplTest {
    private final  CalculatorServiceImpl service = new CalculatorServiceImpl();

    @Test
    void sum() {
        assertEquals(ONE + TWO, service.sum(ONE, TWO));
        assertEquals(TWO + TWO, service.sum(TWO, TWO));
    }

    @Test
    void minus() {
        assertEquals(THREE - TWO, service.minus(THREE, TWO));
        assertEquals(THREE - THREE, service.minus(THREE, THREE));
    }

    @Test
    void multiply() {
        assertEquals(THREE * TWO, service.multiply(THREE, TWO));
        assertEquals(THREE * ONE, service.multiply(THREE, ONE));
    }

    @Test
    void  divide() {
        assertEquals(THREE / ONE, service.divide(THREE, ONE));
        assertEquals(THREE / THREE, service.divide(THREE, THREE));
    }
    @Test
    void  shouldTrowZeroDivideException(){
        assertThrows(ZeroDivideException.class, () -> service.divide(THREE, ZERO));
    }
}