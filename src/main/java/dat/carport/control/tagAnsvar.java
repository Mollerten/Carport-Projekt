package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.City;
import dat.carport.model.entities.PartsList;
import dat.carport.model.entities.Request;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.AdminFacade;
import dat.carport.model.services.CalcFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tagAnsvar extends Command
{

        private ConnectionPool connectionPool;

        public tagAnsvar(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int adminId = user.getId();
        int requestId = Integer.parseInt(request.getParameter("requestid"));
        Request request1 = null;
        User user1 = null;
        City city1 = null;
        PartsList partsList1 = null;



        try
        {
            AdminFacade.addAdminToRequest(adminId, requestId, connectionPool);
            request1 = AdminFacade.hentRequestUdFraId(requestId, connectionPool);
            user1 = AdminFacade.hentUserUdFraID(request1.getCustomerid(), connectionPool);
            city1 = AdminFacade.hentPostalCodeUdFraCity(user1.getCity(), connectionPool);
            partsList1 = CalcFacade.calcPartsList(requestId);
            if (request1.getTotalPrice() == 0) { // if price not frozen
                request1.setTotalPrice(partsList1.getPriceInDKK());
                AdminFacade.setTotalPris(request1.getRequestid(), request1.getTotalPrice(), connectionPool);
            }
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
        }

        request.setAttribute("city", city1);
        request.setAttribute("user", user1);
        request.setAttribute("request", request1);
        request.setAttribute("partsList", partsList1);
        return "requestDetaljer";
    }
}
