package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateUser extends Command
{
    private ConnectionPool connectionPool;

    public CreateUser()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // adding empty user object to session scope

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String tlfnr = request.getParameter("tlfnr");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");

        // Den nedenstående kode skal refactoreres så vi ikke tilføjer til databasen her.
        String sql = "insert into city (city, postal_code) values (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, city);
                ps.setString(2, postalCode);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                } else {
                    throw new DatabaseException("The city with name: = " + city + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert city into database");
        }
        // seriøst, det skal virkelig ikke stå her.


        User user = UserFacade.createUser(username, email, password, tlfnr, address, city, connectionPool);
        session = request.getSession();
        session.setAttribute("user", user); // adding user object to session scope
        return "brugerside";
    }
}
