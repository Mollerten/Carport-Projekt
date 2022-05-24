package dat.carport.model.services;
import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.PartsList;
import dat.carport.model.entities.Request;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.dtos.Material;


import java.util.HashMap;
import java.util.Map;

class Calculator {

    protected static PartsList calcPartsList(int requestId) throws DatabaseException {
        Request request = AdminFacade.hentRequestUdFraId(requestId, ApplicationStart.getConnectionPool());
        int length = request.getLengthcp();
        int width = request.getWidthcp();
        PartsList partsList = new PartsList(requestId);

        int poleCount = calcPoles(length, width);
        Material poles = new Material("97x97 mm. trykimp. Stolpe",
                poleCount,
                300,
                "stk",
                "Stolper nedgraves 90 cm i jord");
        partsList.addMaterial(poles);

        Map<Integer, Integer> beamNumbers = calcBeams(length, width);
        int beamLength = beamNumbers.entrySet().stream().findFirst().get().getKey();
        int beamAmount = beamNumbers.get(beamLength);
        while (beamLength % 60 != 0) beamLength += 15;
        Material beams = new Material("45x195 mm. spærtræ ubh.",
                beamAmount,
                beamLength,
                "stk",
                "Remme i sider, sadles ned i stolper");
        partsList.addMaterial(beams);

        Map<Integer, Integer> rafterNumbers = calcRafters(length, width);
        int rafterLength = rafterNumbers.entrySet().stream().findFirst().get().getKey();
        int rafterAmount = rafterNumbers.get(rafterLength);
        partsList.setRafterCount(rafterNumbers.get(rafterLength));
        int tempRafterLength = rafterLength;
        while (tempRafterLength % 60 != 0) tempRafterLength += 15;
        Material rafters = new Material("45x195 mm. spærtræ ubh.",
                rafterAmount,
                tempRafterLength,
                "stk",
                "Spær, monteres på rem");
        partsList.addMaterial(rafters);

        Map<Integer, Integer> roofSheetNumbers = calcRoofingSheets(length, width);
        int roofSheetSize = roofSheetNumbers.entrySet().stream().findFirst().get().getKey();
        Material roofSheets = new Material("Plastmo Ecolite blåtonet",
                roofSheetNumbers.get(roofSheetSize),
                roofSheetSize,
                "stk",
                "tagplader monteres på spær");
        partsList.addMaterial(roofSheets);

        int boltCount = calcBolts(poleCount);
        Material bolts = new Material("bræddebolt 10 x 120 mm.",
                boltCount,
                0,
                "stk",
                "Til montering af rem på stolper");
        partsList.addMaterial(bolts);

        Map<Integer, Integer> fittingCount = calcFittings(rafterNumbers.get(rafterLength));
        int fittingCountLeft = fittingCount.entrySet().stream().findFirst().get().getKey();
        int fittingCountRight = fittingCount.get(fittingCountLeft);
        Material fittingsRight = new Material("universal 190 mm.",
                fittingCountRight,
                0,
                "stk",
                "Til montering af spær på rem");
        Material fittingsLeft = new Material("universal 190 mm.",
                fittingCountLeft,
                0,
                "stk",
                "Til montering af spær på rem");
        partsList.addMaterial(fittingsRight);
        partsList.addMaterial(fittingsLeft);

        int screwCount = calcScrews(fittingCountLeft+fittingCountRight);
        Material screws = new Material("4,0 x 50 mm. beslagskruer 250 stk.",
                screwCount,
                0,
                "pakke",
                "Til montering af universalbeslag + hulbånd");
        partsList.addMaterial(screws);

        int roofScrewCount = calcRoofScrews(length);
        Material roofScrews = new Material("plastmo bundskruer 200 stk.",
                roofScrewCount,
                0,
                "pakke",
                "Skruer til tagplader");
        partsList.addMaterial(roofScrews);

        int squareFittingCount = calcSquareFittings(poleCount);
        Material squareFittings = new Material("firkantskiver 40x40x11mm",
                squareFittingCount,
                0,
                "stk",
                "Til montering af rem på stolper");
        partsList.addMaterial(squareFittings);

        Map<Integer, Integer> underSternBoardFrontBack = calcUnderSternBoardFrontAndBack(width);
        int underSternBoardFrontBackLength = underSternBoardFrontBack.entrySet().stream().findFirst().get().getKey();
        int underSternBoardFrontBackAmount = underSternBoardFrontBack.get(underSternBoardFrontBackLength);

        while (underSternBoardFrontBackLength % 60 != 0)
        {
            if (underSternBoardFrontBackLength > 600)
            {
                underSternBoardFrontBackLength /= 2;
                underSternBoardFrontBackAmount *= 2;
            }
            underSternBoardFrontBackLength += 15;
        }

        Material underSternBoardsFrontBack = new Material("25x200 mm. trykimp. Brædt",
                underSternBoardFrontBackAmount,
                underSternBoardFrontBackLength,
                "stk",
                "understernbrædder til for & bag ende");
        partsList.addMaterial(underSternBoardsFrontBack);

        Map<Integer, Integer> overSternBoardFront = calcOverSternBoardFront(width);
        int overSternBoardFrontLength = overSternBoardFront.entrySet().stream().findFirst().get().getKey();
        int overSternBoardFrontAmount = overSternBoardFront.get(overSternBoardFrontLength);
        while (overSternBoardFrontLength % 60 != 0)
        {
            if (overSternBoardFrontLength > 600)
            {
                overSternBoardFrontLength /= 2;
                overSternBoardFrontAmount *= 2;
            }
            overSternBoardFrontLength += 15;
        }

        Material overSternBoardsFront = new Material("25x125mm. trykimp. Brædt",
                overSternBoardFrontAmount,
                overSternBoardFrontLength,
                "stk",
                "oversternbrædder til forenden");
        partsList.addMaterial(overSternBoardsFront);

        Map<Integer, Integer> underSternBoardSides = calcUnderSternBoardSides(length);
        int underSternBoardSidesLength = underSternBoardSides.entrySet().stream().findFirst().get().getKey();
        int underSternBoardSidesAmount = underSternBoardSides.get(underSternBoardSidesLength);
        while (underSternBoardSidesLength % 60 != 0)
        {
            if (underSternBoardSidesLength > 600)
            {
                underSternBoardSidesAmount *= 2;
                underSternBoardSidesLength /= 2;
            }
            underSternBoardSidesLength += 15;
        }
        Material underSternBoardsSides = new Material("25x200 mm. trykimp. Brædt",
                underSternBoardSidesAmount,
                underSternBoardSidesLength,
                "stk",
                "understernbrædder til siderne");
        partsList.addMaterial(underSternBoardsSides);

        Map<Integer, Integer> overSternBoardSides = calcOverSternBoardSides(length);
        int overSternBoardSidesLength = overSternBoardSides.entrySet().stream().findFirst().get().getKey();
        int overSternBoardSidesAmount = overSternBoardSides.get(overSternBoardSidesLength);
        while (overSternBoardSidesLength % 60 != 0)
        {
            if (overSternBoardSidesLength > 600)
            {
                overSternBoardSidesLength /= 2;
                overSternBoardSidesAmount *= 2;
            }
            overSternBoardSidesLength += 15;
        }
        Material overSternBoardsSides = new Material("25x125mm. trykimp. Brædt",
                overSternBoardSidesAmount,
                overSternBoardSidesLength,
                "stk",
                "oversternbrædder til siderne");
        partsList.addMaterial(overSternBoardsSides);

        Map<Integer, Integer> waterBoardFront = calcWaterBoardFront(width);
        int waterBoardFrontLength = waterBoardFront.entrySet().stream().findFirst().get().getKey();
        int waterBoardFrontAmount = waterBoardFront.get(waterBoardFrontLength);

        while (waterBoardFrontLength % 60 != 0)
        {
            if (waterBoardFrontLength > 420)
            {
                waterBoardFrontLength /= 2;
                waterBoardFrontAmount *= 2;
            }
            waterBoardFrontLength += 15;
        }
        if (waterBoardFrontLength > 420){
            waterBoardFrontLength /= 2;
            waterBoardFrontAmount *= 2;
        }
        Material waterBoardsFront = new Material("19x100 mm. trykimp. Brædt",
                waterBoardFrontAmount,
                waterBoardFrontLength,
                "stk",
                "vandbrædt på stern i forende");
        partsList.addMaterial(waterBoardsFront);

        Map<Integer, Integer> waterBoardSides = calcWaterBoardSides(length);
        int waterBoardSidesLength = waterBoardSides.entrySet().stream().findFirst().get().getKey();
        int waterBoardSidesAmount = waterBoardSides.get(waterBoardSidesLength);
        while (waterBoardSidesLength % 60 != 0)
        {
            if (waterBoardSidesLength > 420)
            {
                waterBoardSidesLength /= 2;
                waterBoardSidesAmount *= 2;
            }
            waterBoardSidesLength += 15;
        }

        Material waterBoardsSides = new Material("19x100 mm. trykimp. Brædt",
                waterBoardSidesAmount,
                waterBoardSidesLength,
                "stk",
                "vandbrædt på stern i sider");
        partsList.addMaterial(waterBoardsSides);

        int perforatedTapeCount = calcPerforatedTape();
        Material perforatedTape = new Material("hulbånd 1x20 mm. 10 mtr.",
                perforatedTapeCount,
                10,
                "Rulle",
                "Til vindkryds på spær");
        partsList.addMaterial(perforatedTape);

        int sternAndWaterBoardScrewCount = calcSternAndWaterBoardScrews();
        Material sternAndWaterBoardScrews = new Material("4,5 x 60 mm. skruer 200 stk.",
                sternAndWaterBoardScrewCount,
                0,
                "Pakke",
                "Til montering af stern&vandbrædt");
        partsList.addMaterial(sternAndWaterBoardScrews);
        partsList.updatePrice();
        partsList.setRafterCount(rafterNumbers.get(rafterLength));

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
     * Used by {@link #calcPartsList(int)} to get the length and amount of the rafters.
     * @param length the length of the carport
     * @param width the width of the carport
     * @return a {@code Map<Key, Value>} where the key is equal to the length of the rafters
     *         and the value is equal to the amount.
     */
    // rafters = spær
    protected static Map<Integer, Integer> calcRafters(int length, int width)
    {
        Map<Integer, Integer> rafters = new HashMap<>();
        int rafterAmount;
        int rafterLength;

        rafterLength = width;
        rafterAmount = (int) Math.floor((length-10) / 55.0 + 1);

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
            roofingSheetSize = segment * 60;
        }
        if (segment > 10){
           roofingSheetSize = (int) Math.ceil((segment/2)) * 60;
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
    protected  static Map<Integer, Integer> calcFittings (int rafters) {
        Map<Integer, Integer> fittingAmount = new HashMap<>();

        int fittingLeftAmount;
        int fittingRightAmount;

        fittingRightAmount = rafters;
        fittingLeftAmount = rafters;

        fittingAmount.put(fittingLeftAmount, fittingRightAmount);

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

        screwBoxAmount = (int) Math.ceil(length/3f/200f);

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
        int underSternBoardFrontAndBackLength;

        underSternBoardFrontAndBackLength = width + 60;
        underSternBoardFrontAndBackAmount = 2;

        if (width >= 600)
        {
            underSternBoardFrontAndBackLength = width / 2 + 60;
            underSternBoardFrontAndBackAmount = 4;
        }
        underSternBoardFrontAndBack.put(underSternBoardFrontAndBackLength, underSternBoardFrontAndBackAmount);
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







}
