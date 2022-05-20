package dat.carport.model.services;

import dat.carport.model.entities.City;
import dat.carport.model.entities.Request;
import dat.carport.model.entities.Stock;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;
import dtos.RequestListeDTO;
import dtos.StockListeDTO;

import java.util.List;

public class AdminFacade {

    public static List<StockListeDTO> hentStock(ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentStock();
    }

    public static boolean fjernstock(int stock_id, ConnectionPool connectionPool)  throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.fjernstock(stock_id);
    }

    public static List<RequestListeDTO> hentRequest(ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentRequest();
    }

    public static boolean fjernRequest(int request_id, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.fjernRequest(request_id);
    }

    public static Stock hentStockUdFraId(int stockID, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentStockUdFraId(stockID);
    }

    public static boolean opdaterStock(Stock stock, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.opdaterStock(stock);
    }

    public static Stock opretNyStock(Stock stock, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.opretNyStock(stock);
    }

    public static Request hentRequestUdFraId(int requestID, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentRequestUdFraId(requestID);
    }

    public static boolean opdaterRequest(Request request, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.opdaterRequest(request);
    }

    public static double hentStockIdFraDescOgLength(String desc, int length, ConnectionPool connectionPool) throws DatabaseException {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentStockIdFraDescOgLength(desc, length);
    }

    public static User hentUserUdFraID(int customerid, ConnectionPool connectionPool) throws DatabaseException
    {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentUserUdFraID(customerid);
    }

    public static City hentPostalCodeUdFraCity(String city, ConnectionPool connectionPool) throws DatabaseException
    {
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        return adminMapper.hentPostalCodeUdFraCity(city);
    }
}