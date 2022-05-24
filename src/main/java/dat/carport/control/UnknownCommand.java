package dat.carport.control;

import dat.carport.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws DatabaseException
    {
        String msg = "Ukendt kommando. Kontakt IT";
        throw new DatabaseException( msg );
    }

}
