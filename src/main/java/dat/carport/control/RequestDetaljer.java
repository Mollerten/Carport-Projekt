package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.City;
import dat.carport.model.entities.Request;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.AdminFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestDetaljer extends Command
{
    private ConnectionPool connectionPool;

    public RequestDetaljer(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        int requestID = Integer.parseInt(request.getParameter("requestDetaljer"));
        Request request1 = null;
        User user1 = null;
        City city1 = null;

        try
        {
            request1 = AdminFacade.hentRequestUdFraId(requestID, connectionPool);
            user1 = AdminFacade.hentUserUdFraID(request1.getCustomerid(), connectionPool);
            city1 = AdminFacade.hentPostalCodeUdFraCity(user1.getCity(), connectionPool);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
        }
        request.setAttribute("city", city1);
        request.setAttribute("user", user1);
        request.setAttribute("request", request1);
        return "requestDetaljer";
    }
}
