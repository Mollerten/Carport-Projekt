package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.UserFacade;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateUser extends Command
{
    private ConnectionPool connectionPool;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {

        return "createUser";
    }
}
