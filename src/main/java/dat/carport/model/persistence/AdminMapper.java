package dat.carport.model.persistence;
import dat.carport.model.exceptions.DatabaseException;
import dtos.RequestListeDTO;
import dtos.StockListeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMapper implements IAdminMapper {
    ConnectionPool connectionPool;

    public AdminMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public List<StockListeDTO> hentStock() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<StockListeDTO> stockList = new ArrayList<>();

        String sql = "SELECT * FROM carport.stock";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int stockid = rs.getInt("stock_id");
                    String description = rs.getString("description");
                    int amount = rs.getInt("amount");
                    String unit = rs.getString("unit");
                    int price_per_unit = rs.getInt("price_per_unit");

                    StockListeDTO newstock = new StockListeDTO(stockid, description, amount, unit, price_per_unit);
                    stockList.add(newstock);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af lånere fra databasen");
        }
        return stockList;
    }

    @Override
    public boolean fjernstock(int stock_id) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "delete from stock where stock_id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, stock_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                } else
                {
                    throw new DatabaseException("Stock med stockid = " + stock_id + " kunne ikke fjernes");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException("Bog med stockid = " + stock_id + " kunne ikke fjernes");
        }
        return result;
    }


    @Override
    public List<RequestListeDTO> hentRequest() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<RequestListeDTO> requestList = new ArrayList<>();

        String sql = "SELECT * FROM carport.request";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int request_id = rs.getInt("request_id");
                    int length_cp = rs.getInt("length_cp");
                    int width_cp = rs.getInt("width_cp");
                    int length_rr = rs.getInt("length_rr");
                    int width_rr = rs.getInt("width_rr");
                    String roof_mat = rs.getString("roof_mat");
                    String wood_cladding_mat = rs.getString("wood_cladding_mat");
                    int customer_id = rs.getInt("customer_id");
                    int admin_id = rs.getInt("admin_id");

                    RequestListeDTO newstock = new RequestListeDTO(request_id, length_cp, width_cp, length_rr, width_rr,roof_mat,wood_cladding_mat,customer_id,admin_id);
                    requestList.add(newstock);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af lånere fra databasen");
        }
        return requestList;
    }

    @Override
    public boolean fjernRequest(int request_id) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "delete from request where request_id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, request_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                } else
                {
                    throw new DatabaseException("Request med requestId = " + request_id + " kunne ikke fjernes");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException("Luder med requestId = " + request_id + " kunne ikke fjernes");
        }
        return result;
    }
}







