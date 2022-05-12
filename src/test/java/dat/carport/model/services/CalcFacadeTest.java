package dat.carport.model.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcFacadeTest {

    @Test
    void calcRafters() {
        int expected = 15;
        int actual = CalcFacade.calcRafters(780, 600);
        assertEquals(expected, actual);
    }
}