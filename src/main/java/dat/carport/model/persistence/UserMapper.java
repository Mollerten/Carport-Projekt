package dat.carport.model.persistence;

import dat.carport.model.entities.City;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper
{
    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public User login(String username, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String email = rs.getString("email");
                    String tlfnr = rs.getString("tlfnr");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    Boolean isAdmin = rs.getBoolean("isAdmin");
                    String role = isAdmin ? "admin" : "user";
                    int id = rs.getInt("user_id");

                    user = new User(username, email, password, tlfnr, address, city, role, id);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String username, String email, String password, String tlfnr, String address, String city) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, email, password, tlfnr, address, city, isAdmin) values (?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, tlfnr);
                ps.setString(5, address);
                ps.setString(6, city);
                ps.setBoolean(7, false);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(username, email, password, tlfnr, address, city, "user");
                } else
                {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


    @Override
    public User updateUser(String newUsername, String newPassword, String newEmail, String newTlfnr, String newAddress, String newCity, String email, boolean isAdmin) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;

        String sql = "UPDATE `user` SET `username` = ?, `password` = ?, `email` = ?, `tlfnr` = ? , `address` = ? , `city` = ?, `isAdmin` = ? WHERE (`email` = ?);";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, newUsername);
                ps.setString(2, newPassword);
                ps.setString(3, newEmail);
                ps.setString(4, newTlfnr);
                ps.setString(5, newAddress);
                ps.setString(6, newCity);
                ps.setBoolean(7, isAdmin);
                ps.setString(8, email);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    String role = isAdmin ? "admin" : "user";
                    user = new User(newUsername, newEmail, newPassword, newTlfnr, newAddress, newCity, role);
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


    @Override
    public City addCity(String city, String postalCode) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        City city1;


        String sql = "SELECT * FROM city WHERE (city = ?);";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, city);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String cityname = rs.getString("city");
                    String postalCodeName = rs.getString("postal_code");
                    city1 = new City(cityname, postalCodeName);
                } else
                {
                    String sql2 = "insert into city (city, postal_code) values (?,?)";
                    try (Connection connection2 = connectionPool.getConnection()) {
                        try (PreparedStatement ps2 = connection2.prepareStatement(sql2)) {
                            ps2.setString(1, city);
                            ps2.setString(2, postalCode);
                            int rowsAffected = ps2.executeUpdate();
                            if (rowsAffected == 1) {
                                city1 = new City(city, postalCode);
                            } else {
                                throw new DatabaseException("The city with name: = " + city + " could not be inserted into the database");
                            }
                        }
                    } catch (SQLException ex) {
                        throw new DatabaseException(ex, "Could not insert city into database");
                    }

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "An error occured when trying to find your city in the database");
        }

        return city1;
    }
    
    
}
