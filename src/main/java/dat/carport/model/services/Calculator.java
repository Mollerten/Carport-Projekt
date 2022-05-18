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
        int rafters;
        int rafterSpacing;
        int spaceAmount;

//        rafters = (spaceAmount = (int) Math.floor((length - 10) / 55.0)) + 1;
//        The line above and the two below this comment do the same thing, and
//        they are both correct :)
        spaceAmount = (int) Math.floor((length - 10) / 55.0);
        rafters = spaceAmount + 1;

        // This will (probably) be used for the SVG drawing
        rafterSpacing = (int) Math.floor(length / ((double) spaceAmount));

        return rafters;
    }

    protected  static Map<Integer, Integer> calcRoofingSheets (int length, int width) {
        Map<Integer, Integer> roofingSheets = new HashMap<>();
        int segment;
        int carportLength = length;
        int carportWidth = width;
        int roofingSheetSize = 0;
        int roofingSheetAmountWidth;
        int roofingSheetAmountLength = 1;
        int roofingSheetAmountTotal;

        roofingSheetAmountWidth = (int) Math.ceil(carportWidth/(109-20));

        segment = (int) Math.ceil(carportLength/60)+1;

        if (segment<=10){
            roofingSheetSize = segment-3;
        }
        if (segment > 10){
           roofingSheetSize = (int) Math.ceil((segment/2)-3);
           roofingSheetAmountLength = 2;
        }

        roofingSheetAmountTotal = roofingSheetAmountLength * roofingSheetAmountWidth;
        roofingSheets.put(roofingSheetSize, roofingSheetAmountTotal);
        return roofingSheets;
    }

    protected static int calcBolts(int poles){
        int boltAmount;

        boltAmount = poles * 2;

        return boltAmount;
    }

    protected static int calcFittings(int rafters){
        int fittingAmount;

        fittingAmount = rafters * 2;

        return fittingAmount;
    }

    protected static int calcScrews(int fittings){
        int screwAmount;

        screwAmount = fittings * 9;

        return screwAmount;
    }

    protected static int calcRoofScrews(int length) {
        int screwBoxAmount;

        screwBoxAmount = (int) Math.ceil(length/3);

        return  screwBoxAmount;
    }

    protected static int calcSquareFittings(int poles)
    {
        int squareFittingAmount;

        squareFittingAmount = poles;

        return squareFittingAmount;
    }










}
