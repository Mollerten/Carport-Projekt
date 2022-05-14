package dat.carport.model.persistence;

import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;
import dtos.StockListeDTO;

import java.util.List;

public interface IAdminMapper {

    List<StockListeDTO> hentStock() throws DatabaseException;

    boolean fjernstock(int stockid) throws DatabaseException;

    Stock hentStockUdFraId(int stockID) throws DatabaseException;
}
