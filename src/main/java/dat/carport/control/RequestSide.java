package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.persistence.ConnectionPool;
import dtos.RequestListeDTO;
import dtos.StockListeDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RequestSide extends Command {

    private ConnectionPool connectionPool;

    public RequestSide(){this.connectionPool = ApplicationStart.getConnectionPool();}

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

            AdminMapper adminMapper = new AdminMapper(connectionPool);
            List<RequestListeDTO> requestListeDTOS = null;
            try
            {
                requestListeDTOS = adminMapper.hentRequest();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            request.setAttribute("requestliste",requestListeDTOS);

            return "requestside";
        }
    }