package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Request;
import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedigerRequest extends Command {
    private ConnectionPool connectionPool;

    public RedigerRequest(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        String idString = request.getParameter("redigerrequest");
        int requestid = Integer.parseInt(idString);
        Request request1 = null;
        AdminMapper adminMapper = new AdminMapper(connectionPool);

        try
        {
            request1 = adminMapper.hentRequestUdFraId(requestid);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());

        }
        request.setAttribute("request", request1);
        return "redigerrequest";
    }
}
