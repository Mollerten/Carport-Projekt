package dat.carport.model.services;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Map<Integer, Integer> expe1 = Collections.singletonMap(360, 14);
        assertEquals(expe1, test1);

        Map<Integer, Integer> test2 = Calculator.calcRoofingSheets(420, 360);
        Map<Integer, Integer> expe2 = Collections.singletonMap(480, 5);
        assertEquals(expe2, test2);
    }

    @Test
    void calcBolts() {
        int bolts = Calculator.calcBolts(13);
        assertEquals(26, bolts);
    }

    @Test
    void calcFittings() {
        Map<Integer, Integer> test1 = Calculator.calcFittings(15);
        Map<Integer, Integer> expe1 = Collections.singletonMap(15, 15);
        assertEquals(expe1, test1);
    }

    @Test
    void calcScrews() {
        int test1 = Calculator.calcScrews(30);
        assertEquals(2, test1);
    }

    @Test
    void calcRoofScrews() {
        int test1 = Calculator.calcRoofScrews(600);
        assertEquals(1, test1);
    }

    @Test
    void calcSquareFittings() {
        int test1 = Calculator.calcSquareFittings(6);
        assertEquals(6, test1);
    }

    @Test
    void calcUnderSternBoardFrontAndBack() {
        Map<Integer, Integer> test1 = Calculator.calcUnderSternBoardFrontAndBack(600);
        Map<Integer, Integer> expe1 = Collections.singletonMap(360, 4);
        assertEquals(expe1, test1);
    }

    @Test
    void calcOverSternBoardFront() {
        Map<Integer, Integer> test1 = Calculator.calcOverSternBoardFront(600);
        Map<Integer, Integer> expe1 = Collections.singletonMap(360, 2);
        assertEquals(expe1, test1);
    }

    @Test
    void calcUnderSternBoardSides() {
        Map<Integer, Integer> test1 = Calculator.calcUnderSternBoardSides(780);
        Map<Integer, Integer> expe1 = Collections.singletonMap(450, 4);
        assertEquals(expe1, test1);
    }

    @Test
    void calcOverSternBoardSides() {
        Map<Integer, Integer> test1 = Calculator.calcOverSternBoardSides(780);
        Map<Integer, Integer> expe1 = Collections.singletonMap(450, 4);
        assertEquals(expe1, test1);
    }

    @Test
    void calcWaterBoardFront() {
        Map<Integer, Integer> test1 = Calculator.calcWaterBoardFront(600);
        Map<Integer, Integer> expe1 = Collections.singletonMap(360, 2);
        assertEquals(expe1, test1);
    }

    @Test
    void calcWaterBoardSides() {
        Map<Integer, Integer> test1 = Calculator.calcWaterBoardSides(780);
        Map<Integer, Integer> expe1 = Collections.singletonMap(450, 4);
        assertEquals(expe1, test1);
    }
}