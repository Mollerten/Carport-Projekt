package dat.carport.model.persistence;

import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMapper implements IAdminMapper {
    ConnectionPool connectionPool;

    public AdminMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }}

 /*   @Override
    public User opdaterstock(String username, String password) throws DatabaseException
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

                    user = new User(username, email, password, tlfnr, address, city, role);
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
}*/





