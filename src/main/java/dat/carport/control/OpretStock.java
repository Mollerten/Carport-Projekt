package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpretStock extends Command {
    private ConnectionPool connectionPool;

    public OpretStock(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        response.setContentType("text/html");

        int stockId;
        String description = request.getParameter("description");

        String amountString = request.getParameter("amount");
        int amount = Integer.parseInt(amountString);

        String unit = request.getParameter("stockunit");

        String pricePerUnitstring = request.getParameter("priceperunit");
        int price_per_unit = Integer.parseInt(pricePerUnitstring);



        Stock stock = new Stock(description, amount, unit, price_per_unit);
        AdminMapper adminMapper = new AdminMapper(connectionPool);
        try
        {
            Stock nyStock = adminMapper.opretNyStock(stock);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }
        return "brugerside";
    }
}


