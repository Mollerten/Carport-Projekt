package dat.carport.model.persistence;
import dat.carport.model.entities.*;
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

        String sql = "SELECT * FROM stock";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    long stockid = rs.getLong("stock_id");
                    String description = rs.getString("description");
                    int amount = rs.getInt("length");
                    String unit = rs.getString("unit");
                    double price_per_unit = rs.getDouble("price_per_unit");

                    StockListeDTO newstock = new StockListeDTO(stockid, description, amount, unit, price_per_unit);
                    stockList.add(newstock);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af stock fra databasen");
        }
        return stockList;
    }

    @Override
    public boolean fjernstock(int stock_id) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "delete from stock where stock_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, stock_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Stock med stockid = " + stock_id + " kunne ikke fjernes");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Bog med stockid = " + stock_id + " kunne ikke fjernes");
        }
        return result;
    }

    @Override
    public List<RequestListeDTO> hentRequest() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<RequestListeDTO> requestList = new ArrayList<>();

        String sql = "SELECT * FROM request";


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

                    RequestListeDTO newstock = new RequestListeDTO(request_id, length_cp, width_cp, length_rr, width_rr, roof_mat, wood_cladding_mat, customer_id, admin_id);
                    requestList.add(newstock);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indlæsning af lånere fra databasen");
        }
        return requestList;
    }

    @Override
    public boolean fjernRequest(int request_id) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "delete from request where request_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, request_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Request med requestID = " + request_id + " kunne ikke fjernes");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Request med requestId = " + request_id + " kunne ikke fjernes");
        }
        return result;
    }

    @Override
    public Stock hentStockUdFraId(int stockID) throws DatabaseException {
        {
            Logger.getLogger("web").log(Level.INFO, "bogId=" + stockID);
            Stock stock = null;
            String sql = "select * from stock where stock_id = ?";
            try (Connection connection = connectionPool.getConnection()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, stockID);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        int stockid = rs.getInt("stock_id");
                        String description = rs.getString("description");
                        int amount = rs.getInt("amount");
                        String unit = rs.getString("unit");
                        int price_per_unit = rs.getInt("price_per_unit");

                        stock = new Stock(stockid, description, amount, unit, price_per_unit);
                    } else {
                        throw new DatabaseException("Stock med stock_id = " + stockID + " findes ikke");
                    }
                }
            } catch (SQLException ex) {
                throw new DatabaseException("Stock med stock_id = " + stockID + " findes ikke");
            }
            return stock;
        }
    }

    public boolean opdaterStock(Stock stock) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "UPDATE stock SET description = ?, length = ?, unit = ?, price_per_unit = ? " +
                "WHERE stock_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, stock.getDescription());
                ps.setInt(2, stock.getAmount());
                ps.setString(3, stock.getUnit());
                ps.setDouble(4, stock.getPrice_per_unit());
                ps.setLong(5, stock.getStockid());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Kunne ikke opdatere stock med getStock_id = " + stock.getStockid());
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Kunne ikke opdatere stock med getStock_id = " + stock.getStockid());
        }
        return result;
    }

    @Override
    public Stock opretNyStock(Stock stock) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        int newId = 0;
        String sql = "insert into stock (stock_id, description, length, unit, price_per_unit) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, stock.getStockid());
                ps.setString(2, stock.getDescription());
                ps.setInt(3, stock.getAmount());
                ps.setString(4, stock.getUnit());
                ps.setDouble(5, stock.getPrice_per_unit());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("stock med beskrivelse = " + stock.getDescription() + " kunne ikke oprettes i databasen");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Kunne ikke indsætte stock i databasen");
        }
        return stock;
    }

    @Override
    public Request hentRequestUdFraId(int requestID) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "bogId=" + requestID);
        Request request = null;
        String sql = "select * from request where request_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, requestID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    int requestid = rs.getInt("request_id");
                    int lengthcp = rs.getInt("length_cp");
                    int widthcp = rs.getInt("width_cp");
                    int lengthrr = rs.getInt("length_rr");
                    int widthrr = rs.getInt("width_rr");
                    String roofmat = rs.getString("roof_mat");
                    String woodcladding = rs.getString("wood_cladding_mat");
                    double totalPrice = rs.getDouble("total_price");
                    int customerid = rs.getInt("customer_id");
                    int adminid = rs.getInt("admin_id");

                    request = new Request(requestid, lengthcp, widthcp, lengthrr, widthrr,
                            roofmat, woodcladding, totalPrice, customerid, adminid);
                } else {
                    throw new DatabaseException("Request med request_id = " + requestID + " findes ikke");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Request med request_id = " + requestID + " findes ikke");
        }
        return request;
    }

    @Override
    public boolean opdaterRequest(Request request) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "UPDATE request SET length_cp = ?, width_cp = ?, length_rr = ?, width_rr = ?, roof_mat = ?, wood_cladding_mat = ?, customer_id = ?, admin_id = ? " +
                "WHERE request_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, request.getLengthcp());
                ps.setInt(2, request.getWidthcp());
                ps.setInt(3, request.getLengthrr());
                ps.setInt(4, request.getWidthrr());
                ps.setString(5, request.getRoofmat());
                ps.setString(6, request.getWoodcladding());
                ps.setInt(7, request.getCustomerid());
                ps.setInt(8, request.getAdminid());
                ps.setInt(9, request.getRequestid());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Kunne ikke opdatere request med request_id = " + request.getRequestid());
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Kunne ikke opdatere request med request_id = " + request.getRequestid());
        }
        return result;
    }

    @Override
    public Request opretRequest(Request request) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        int newId = 0;
        String sql = "insert into request (length_cp, width_cp,length_rr,width_rr,roof_mat,wood_cladding_mat,customer_id) values (?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, request.getLengthcp());
                ps.setInt(2, request.getWidthcp());
                ps.setInt(3, request.getLengthrr());
                ps.setInt(4, request.getWidthrr());
                ps.setString(5, request.getRoofmat());
                ps.setString(6, request.getWoodcladding());
                ps.setInt(7, request.getCustomerid());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                } else
                {
                    throw new DatabaseException("request med request id = " + request.getRequestid() + " kunne ikke oprettes i databasen");
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next())
                {
                    newId = idResultset.getInt(1);
                    request.setRequestid(newId);
                } else
                {
                    request = null;
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke indsætte request i databasen");
        }
        return request;
    }

    public double hentStockIdFraDescOgLength(String desc, int length) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        double stockId = 0;
        String sql = "SELECT stock_id FROM stock WHERE description = ? AND length = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, desc);
                ps.setInt(2, length);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    stockId = rs.getDouble(1);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error: ID på stock med desc = \"" + desc +
                    "\" og length = \"" + length + "\" kunne ikke findes.");
        }
        return stockId;
    }

    @Override
    public User hentUserUdFraID(int customerid) throws DatabaseException
    {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, customerid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String tlfnr = rs.getString("tlfnr");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    String password = rs.getString("password");
                    Boolean isAdmin = rs.getBoolean("isAdmin");
                    String role = isAdmin ? "admin" : "user";
                    int id = rs.getInt("user_id");

                    user = new User (username, email, password, tlfnr, address, city, role, id);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not find a user from this id");
        }
        return user;
    }
    @Override
    public City hentPostalCodeUdFraCity(String city) throws DatabaseException
    {
        City city1 = null;
        String sql = "SELECT * FROM city WHERE city = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, city);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String cityname = rs.getString("city");
                    String postalCode = rs.getString("postal_code");

                    city1 = new City(cityname, postalCode);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not find city");
        }
        return city1;
    }


    public double hentPriceUdFraStockID(double stockID) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        double price = 0;
        String sql = "SELECT price_per_unit FROM stock WHERE stock_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, stockID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    price = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Error: ");
        }
        return price;
    }


    public void addAdminToRequest(int adminId, int requestId) throws DatabaseException
    {


        String sql = "UPDATE `request` SET `admin_id` = ? WHERE (`request_id` = ?);";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, adminId);
                ps.setInt(2, requestId);

                ps.executeUpdate();

            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert admin-id into database");
        }

    }

    public void setTotalPriceForRequest(int requestid, double totalPrice) {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE request SET total_price = ? WHERE request_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, totalPrice);
                ps.setInt(2, requestid);

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

