package dat.carport.model.persistence;

import dat.carport.model.entities.City;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;

public interface IUserMapper
{
    public User login(String email, String password) throws DatabaseException;
    public User createUser(String username, String email, String password, String tlfnr, String address, String city) throws DatabaseException;
    public User updateUser(String newUsername, String newPassword, String newEmail, String newTlfnr, String newAddress, String newCity, String email, boolean isAdmin) throws DatabaseException;

    City addCity(String city, String postalCode) throws DatabaseException;
}
