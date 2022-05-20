package dat.carport.control;

import dat.carport.model.entities.Stock;
import dat.carport.model.exceptions.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("logout", new Logout());
        commands.put("about", new About());
        commands.put("createUser", new CreateUser());
        commands.put("svgtest", new SVGTest());
        commands.put("brugerside", new Brugerside());
        commands.put("requestside", new RequestSide());
        commands.put("updateUser", new UpdateUser());
        commands.put("fjernrequest", new FjernRequest());
        commands.put("redigerrequest", new RedigerRequest());
        commands.put("opdaterrequest", new OpdaterRequest());
        commands.put("stockside", new StockSide());
        commands.put("fjernstock", new FjernStock());
        commands.put("redigerstock", new RedigerStock());
        commands.put("opdaterstock", new OpdaterStock());
        commands.put("opretstock", new OpretStock());
        commands.put("opretstockside", new OpretStockSide());
        commands.put("profil", new Profil());
        commands.put("requestDetaljer", new RequestDetaljer());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response )
            throws DatabaseException;

}
