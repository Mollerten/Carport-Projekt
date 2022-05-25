package dat.carport.model.services;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcPoles() {
        // short carport eg. length < 410
        int polesShort = Calculator.calcPoles(390);
        assertEquals(4, polesShort);

        // long carport eg. length > 410
        int polesLong = Calculator.calcPoles(600);
        assertEquals(6, polesLong);
    }

    @Test
    void calcBeams() {
        // short carport eg. length < 410
        Map<Integer, Integer> beamsShort = Calculator.calcBeams(390);
        Map<Integer, Integer> expectedShort = Collections.singletonMap(390, 2);
        assertEquals(expectedShort, beamsShort);

        // long carport eg. length > 410
        Map<Integer, Integer> beamsLong = Calculator.calcBeams(600);
        Map<Integer, Integer> expectedLong = Collections.singletonMap(300, 4);
        assertEquals(expectedLong, beamsLong);
    }

    @Test
    void calcRafters() {
        // test 1
        Map<Integer, Integer> test1 = Calculator.calcRafters(600, 540);
        Map<Integer, Integer> expected1 = Collections.singletonMap(540, 11);
        assertEquals(expected1, test1);

        // test 2
        Map<Integer, Integer> test2 = Calculator.calcRafters(420, 360);
        Map<Integer, Integer> expected2 = Collections.singletonMap(360, 8);
        assertEquals(expected2, test2);
    }

    @Test
    void calcRoofingSheets() {
        Map<Integer, Integer> test1 = Calculator.calcRoofingSheets(600, 540);
        Map<Integer, Integer> expe1 = Collections.singletonMap()
    }
}