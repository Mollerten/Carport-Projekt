package dat.carport.model.persistence;
import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
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
}







