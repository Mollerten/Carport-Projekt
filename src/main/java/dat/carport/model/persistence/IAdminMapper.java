package dat.carport.model.persistence;

import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
import dtos.RequestListeDTO;
import dtos.StockListeDTO;

import java.util.List;

public interface IAdminMapper {

    List<StockListeDTO> hentStock() throws DatabaseException;

    boolean fjernstock(int stockid) throws DatabaseException;

    List<RequestListeDTO> hentRequest() throws DatabaseException;
}
