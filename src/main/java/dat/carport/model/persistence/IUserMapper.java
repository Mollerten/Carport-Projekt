package dat.carport.model.persistence;

import dat.carport.model.entities.Stock;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;

import java.util.List;

public interface IUserMapper
{
    public User login(String email, String password) throws DatabaseException;
    public User createUser(String username, String email, String password, String tlfnr, String address, String city, String isAdmin) throws DatabaseException;

}
