package com.example.demo.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestMathTest {

    @Test
    void sum_with_3nums() {
        TestMath math = new TestMath();
        Integer result = math.addAllIn(Arrays.asList(1,2,3));
        assertEquals(6, result);
    }
}