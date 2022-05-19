package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Request;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpdaterRequest extends Command {
    private ConnectionPool connectionPool;

    public OpdaterRequest(){this.connectionPool = ApplicationStart.getConnectionPool();}



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        String idString = request.getParameter("request_id");
        int requestID = Integer.parseInt(idString);

        String lengthCpString = request.getParameter("length_cp");
        int lengthCP = Integer.parseInt(lengthCpString);

        String widthCpString = request.getParameter("width_cp");
        int widthCP = Integer.parseInt(widthCpString);

        String lengthRrString = request.getParameter("length_rr");
        int lengthRR = Integer.parseInt(lengthRrString);

        String widthRrString = request.getParameter("width_rr");
        int widthRR = Integer.parseInt(widthRrString);


        String customerIdString = request.getParameter("customer_id");
        int customerID = Integer.parseInt(customerIdString);

        String adminIdString = request.getParameter("admin_id");
        int adminID = Integer.parseInt(adminIdString);

        String roofMat = request.getParameter("roofmat");

        String woodCladdingMat = request.getParameter("woodcladdingmat");


        Request request1 = new Request(requestID, lengthCP, widthCP, lengthRR, widthRR, roofMat, woodCladdingMat, customerID, adminID);
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        try
        {
            boolean result = adminMapper.opdaterRequest(request1);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }
        return "brugerside";
    }
}
