package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FjernStock extends Command
{
    private ConnectionPool connectionPool;

    public FjernStock(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        String idString = request.getParameter("fjernstock");

        int stockId = Integer.parseInt(idString);

        AdminMapper adminMapper = new AdminMapper(connectionPool);

        try
        {
            adminMapper.fjernstock(stockId);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }
        return "brugerside";
    }
}