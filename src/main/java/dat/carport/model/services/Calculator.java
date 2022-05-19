package dat.carport.model.services;

import dat.carport.model.entities.PartsList;
import dtos.Material;

import java.util.HashMap;
import java.util.Map;

class Calculator {

    protected static PartsList calcPartsList(int length, int width, int requestId) {
        PartsList partsList = new PartsList(requestId);
        int poleCount = calcPoles(length, width);
        Material poles = new Material("", poleCount, 300, "stk", "Stolper nedgraves 90 cm i jord");
        partsList.addMaterial(poles);

        return partsList;
    }

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
    protected static Map<Integer, Integer> calcRafters(int length, int width)
    {
        Map<Integer, Integer> rafters = new HashMap<>();
        int rafterAmount;
        int rafterLength;

        rafterLength = width;
        rafterAmount = (int) Math.floor((length-10) / 55 + 1);

        rafters.put(rafterLength, rafterAmount);
        return rafters;
    }
    /**
     *
     * @param length The length of the carport
     * @param width The width of the carport
     * @return A {@code Map<Key, Value>} where keys are equal to the length of the roofing sheet
     * and values are equal to the amount of roofing sheets with that length.
     */
    // roofingsheets = tagplader
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

    // Universal 190 mm venstre + højre bliver udregnet her
    protected static int calcFittings(int rafters){
        int fittingAmount;

        fittingAmount = rafters * 2;

        return fittingAmount;
    }

    // beslagskruer 4,0x50 mm til montering af beslag + hulbånd
    protected static int calcScrews(int fittings){
        int screwAmount;
        int screwBoxAmount;

        screwAmount = fittings * 9;

        screwBoxAmount = (int) Math.ceil(screwAmount/250);

        return screwBoxAmount;
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
    protected static Map<Integer, Integer> calcUnderSternBoardFrontAndBack (int width)
    {
        Map<Integer, Integer> underSternBoardFrontAndBack = new HashMap<>();
        int underSternBoardFrontAndBackAmount;
        int underSternBoardFrontAndBackWidth;

        underSternBoardFrontAndBackWidth = width + 60;
        underSternBoardFrontAndBackAmount = 2;

        if (width >= 600)
        {
            underSternBoardFrontAndBackWidth = width / 2 + 60;
            underSternBoardFrontAndBackAmount = 4;
        }
        underSternBoardFrontAndBack.put(underSternBoardFrontAndBackWidth, underSternBoardFrontAndBackAmount);
        return underSternBoardFrontAndBack;
    }

    protected static Map<Integer, Integer> calcOverSternBoardFront(int width)
    {
        Map<Integer, Integer> overSternBoardFront = new HashMap<>();
        int overSternBoardFrontAmount;
        int overSternBoardFrontWidth;

        overSternBoardFrontWidth = width + 60;
        overSternBoardFrontAmount = 1;

        if (width >= 600)
        {
            overSternBoardFrontWidth = width / 2 + 60;
            overSternBoardFrontAmount = 2;
        }
        overSternBoardFront.put(overSternBoardFrontWidth, overSternBoardFrontAmount);
        return overSternBoardFront;
    }
    protected  static Map<Integer, Integer> calcUnderSternBoardSides (int length) {
        Map<Integer, Integer> underSternBoardSides = new HashMap<>();
        int underSternBoardSidesAmount;
        int underSternBoardSidesLength;

        underSternBoardSidesLength = length + 60;
        underSternBoardSidesAmount = 2;

        if (length >= 600)
        {
            underSternBoardSidesAmount = 4;
            underSternBoardSidesLength = length / 2 + 60;
        }
        underSternBoardSides.put(underSternBoardSidesLength, underSternBoardSidesAmount);
        return underSternBoardSides;
    }

    protected  static Map<Integer, Integer> calcOverSternBoardSides (int length) {
        Map<Integer, Integer> overSternBoardSides = new HashMap<>();
        int overSternBoardSidesAmount;
        int overSternBoardSidesLength;

        overSternBoardSidesLength = length + 60;
        overSternBoardSidesAmount = 2;

        if (length >= 600)
        {
            overSternBoardSidesAmount = 4;
            overSternBoardSidesLength = length / 2 + 60;
        }
        overSternBoardSides.put(overSternBoardSidesLength, overSternBoardSidesAmount);
        return overSternBoardSides;
    }

    protected static Map<Integer, Integer> calcWaterBoardFront (int width)
    {
        Map<Integer, Integer> waterBoardFront = new HashMap<>();
        int waterBoardFrontAmount;
        int waterBoardFrontWidth;

        waterBoardFrontAmount = 1;
        waterBoardFrontWidth = width + 60;

        if (width >= 600)
        {
            waterBoardFrontAmount = 2;
            waterBoardFrontWidth = width / 2 + 60;
        }
        waterBoardFront.put(waterBoardFrontWidth, waterBoardFrontAmount);
        return waterBoardFront;
    }

    protected static Map<Integer, Integer> calcWaterBoardSides (int length)
    {
        Map<Integer, Integer> waterBoardSides = new HashMap<>();
        int waterBoardSidesAmount;
        int waterBoardSidesWidth;

        waterBoardSidesAmount = 2;
        waterBoardSidesWidth = length + 60;

        if (length >= 600)
        {
            waterBoardSidesAmount = 4;
            waterBoardSidesWidth = length / 2 + 60;
        }
        waterBoardSides.put(waterBoardSidesWidth, waterBoardSidesAmount);
        return waterBoardSides;
    }

    protected static int calcPerforatedTape ()
    {
        return 2; // hverken mere eller mindre, take it or leave it.
    }

    protected static int calcSternAndWaterBoardScrews ()
    {
        return 1;
    }

    /*
    //TODO: lav entity: material med attributer: int stockID, String beskrivelse, int antal, String længde, String enhed, String hjælpetekst
    //TODO: lav calcMaterial der udregner hvilke materialer der er behov for, og hvor meget
    //TODO: lav calcPrice der tager entiteten material og udregner pris ift prisen i stock
    //TODO: lav entitet: stykliste med attributer: material, int requestID og int pris (udregnet fra calcPrice)




     */







}
