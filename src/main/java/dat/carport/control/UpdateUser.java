package dat.carport.control;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateUser extends Command
{

        private ConnectionPool connectionPool;

        public UpdateUser()
        {
            this.connectionPool = ApplicationStart.getConnectionPool();
        }


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String tlfnr = user.getTlfnr();
        String address = user.getAddress();
        String city = user.getCity();
        boolean isAdmin = Boolean.parseBoolean(user.getRole());

        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        String newEmail = request.getParameter("newEmail");
        String confirmNewEmail = request.getParameter("confirmNewEmail");
        String newTlfnr = request.getParameter("newTlfnr");
        String newAddress = request.getParameter("newAddress");
        String newCity = request.getParameter("newCity");
        String newPostalCode = request.getParameter("newPostalCode");

        String oldPassword = request.getParameter("oldPassword");

        // Hvis blanketten ikke er udfyldt sættes brugernavn til forrige
        if (newUsername.equals("")) {
            newUsername = username;
        }

        // Hvis den nye kode ikke er udfyldt, eller de to indtastede koder ikke stemmer overens sættes koden til forrige.
        if (newPassword.equals("")) { //
            newPassword = password;
            confirmNewPassword = password;
        }

        if (!newPassword.equals("") && !newPassword.equals(confirmNewPassword)) {
            request.setAttribute("errormsg", "You failed to confirm your new password.");
            return "updateUser";
        }

        // Hvis blanketten er udfyldt og de to nye emails stemmer overens skiftes emailen
        if (newEmail.equals("")) {
            newEmail = email;
            confirmNewEmail = email;
        }
        if (!newEmail.equals("") && !newEmail.equals(confirmNewEmail)) {
            request.setAttribute("errormsg", "You failed to confirm your new email.");
            return "updateUser";
        }

        // Hvis blanketten ikke er udfyldt sættes tlfnr til det forrige
        if (newTlfnr.equals("")) {
            newTlfnr = tlfnr;
        }

        // Hvis blanketten ikke er udfyldt sættes address til det forrige
        if (newAddress.equals("")) {
            newAddress = address;
        }

        // Hvis blanketten ikke er udfyldt sættes city til det forrige
        if (newCity.equals("")) {
            newCity = city;
        }





        user = UserFacade.updateUser(newUsername, newPassword, newEmail, newTlfnr, newAddress, newCity, email, isAdmin, connectionPool);



                return "index";


    }
}
