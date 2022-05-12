package dat.carport.model.services;

import java.util.HashMap;
import java.util.Map;

class Calculator {
    private static int[] beamLengths = {300, 360, 420, 480, 540, 600}; //, 660, 720};

    /**
     *
     * @param length The length of the carport
     * @param width The width of the carport
     * @return How many poles are needed for the given carport dimensions.
     */
    // poles = stolper
    protected static int calcPoles(int length, int width) {
        int poleCount = 4;
        if ((length - 100) > 310) {
            poleCount += 2;
        }
        return poleCount;
    }

    /**
     *
     * @param length The length of the carport
     * @param width The width of the carport
     * @return A {@code Map<Key, Value>} where keys are equal to the length of the beam
     * and values are equal to the amount of beams with that length.
     */
    // beams = rem
    protected static Map<Integer, Integer> calcBeams(int length, int width) {
        Map<Integer, Integer> beams = new HashMap<>();
        int beamLength;
        int beamCount;
        if (length > 410) {
            beamLength = length / 2;
            beamCount = 4;
        } else {
            beamLength = length;
            beamCount = 2;
        }
        beams.put(beamLength, beamCount);
        return beams;
    }

    /**
     *
     * @param length The length of the carport
     * @param width The width of the carport
     * @return The amount of rafters needed for the given carport dimensions.
     */
    // rafters = spær
    protected static int calcRafters(int length, int width) {
        return 15;
    }
}
