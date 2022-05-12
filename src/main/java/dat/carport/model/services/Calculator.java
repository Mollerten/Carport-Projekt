package dat.carport.model.services;

class Calculator {
    private static int[] beamLengths = {480, 510, 540, 570, 600};

    // poles = stolper
    protected static int calcPoles(int length, int width) {
        int poleCount = 4;
        if ((length - 100) > 310) {
            poleCount += 2;
        }
        return poleCount;
    }

    // rafters = spær
    protected static int calcRafters(int length, int width) {
        return 0;
    }

    // beams = rem
    protected static int calcBeams(int length, int width) {
        return 0;
    }
}
