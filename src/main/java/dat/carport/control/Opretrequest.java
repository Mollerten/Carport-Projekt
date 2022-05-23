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

public class Opretrequest extends Command
{
    private ConnectionPool connectionPool;

    public Opretrequest(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        response.setContentType("text/html");
        int length_cp = Integer.parseInt(request.getParameter("length_cp"));
        int width_cp = Integer.parseInt(request.getParameter("width_cp"));
        int length_rr = Integer.parseInt(request.getParameter("length_rr"));
        int width_rr = Integer.parseInt(request.getParameter("width_rr"));
        String roof_mat = request.getParameter("roof_mat");
        String wood_cladding_mat = request.getParameter("wood_cladding_mat");
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));

        Request request1 = new Request(length_cp, width_cp, length_rr, width_rr,roof_mat,wood_cladding_mat,customer_id);
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        try
        {
            Request nyRequest = adminMapper.opretRequest(request1);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }
        return "OpretRequest";
    }

}
