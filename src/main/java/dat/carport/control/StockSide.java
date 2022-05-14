package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;
import dtos.StockListeDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StockSide extends Command
{
    private ConnectionPool connectionPool;

    public StockSide(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        AdminMapper adminMapper = new AdminMapper(connectionPool);
        List<StockListeDTO> stockListeDTOS = null;
        try
        {
            stockListeDTOS = adminMapper.hentStock();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("stockliste",stockListeDTOS);

        return "stockside";
    }
}
