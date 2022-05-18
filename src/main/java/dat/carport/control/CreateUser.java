package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.City;
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


        City city1 = UserFacade.addCity(city, postalCode, connectionPool);
        User user = UserFacade.createUser(username, email, password, tlfnr, address, city, connectionPool);
        session = request.getSession();
        session.setAttribute("city", city1);
        session.setAttribute("user", user); // adding user object to session scope
        return "brugerside";
    }
}
