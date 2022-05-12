package dat.carport.model.services;

import java.util.Map;

public class CalcFacade {

    public static int calcPoles(int length, int width) {
        return Calculator.calcPoles(length, width);
    }

    public static Map<Integer, Integer> calcBeams(int length, int width) {
        return Calculator.calcBeams(length, width);
    }

}