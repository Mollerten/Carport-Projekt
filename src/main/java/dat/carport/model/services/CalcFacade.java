package dat.carport.model.services;

import dat.carport.model.entities.PartsList;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;

import java.util.Map;

public class CalcFacade {

    public static int calcPoles(int length) {
        return Calculator.calcPoles(length);
    }

    public static Map<Integer, Integer> calcBeams(int length) {
        return Calculator.calcBeams(length);
    }

    public static Map<Integer, Integer> calcRafters(int length, int width) {
        return Calculator.calcRafters(length, width);
    }

    public static PartsList calcPartsList(int requestID) throws DatabaseException
    {
        return Calculator.calcPartsList(requestID);
    }
}