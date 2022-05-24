package dat.carport.model.persistence;

import dat.carport.model.entities.City;
import dat.carport.model.entities.Request;
import dat.carport.model.entities.Stock;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.dtos.RequestListeDTO;
import dat.carport.dtos.StockListeDTO;

import java.util.List;

public interface IAdminMapper {

    List<StockListeDTO> hentStock() throws DatabaseException;

    boolean fjernstock(int stockid) throws DatabaseException;


    List<RequestListeDTO> hentRequest() throws DatabaseException;

    boolean fjernRequest(int requestId) throws DatabaseException;

    Stock hentStockUdFraId(int stockID) throws DatabaseException;

    Stock opretNyStock(Stock bog) throws DatabaseException;

    Request hentRequestUdFraId(int requestID) throws DatabaseException;

    boolean opdaterRequest(Request request) throws DatabaseException;

    Request opretRequest(Request request) throws DatabaseException;

    double hentStockIdFraDescOgLength(String desc, int length) throws DatabaseException;

    User hentUserUdFraID(int customerid) throws DatabaseException;

    City hentPostalCodeUdFraCity(String city) throws DatabaseException;
}
