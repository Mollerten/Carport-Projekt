package dat.carport.model.services;

public class CalcFacade {

    public static int calcPoles(int length, int width) {
        return Calculator.calcPoles(length, width);
    }

    public static int calcBeams(int length, int width) {
        return Calculator.calcRafters(length, width);
    }

}