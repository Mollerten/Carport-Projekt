package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.AdminFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FjernRequest extends Command
{
    private ConnectionPool connectionPool;

    public FjernRequest(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        int requestId = Integer.parseInt(request.getParameter("fjernrequest"));

        try
        {
            AdminFacade.fjernRequest(requestId, connectionPool);

        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }
        return "brugerside";
    }
}
