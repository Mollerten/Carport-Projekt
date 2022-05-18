package dat.carport.model.services;

import dat.carport.model.entities.City;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.UserMapper;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.login(username, password);
    }

    public static User createUser(String username, String email, String password, String tlfnr, String address, String city, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.createUser(username, email, password, tlfnr, address, city);
    }

    public static User updateUser(String newUsername, String newPassword, String newEmail, String newTlfnr, String newAddress, String newCity, String email, boolean isAdmin, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.updateUser(newUsername, newPassword, newEmail, newTlfnr, newAddress, newCity, email, isAdmin);
    }

    public static City addCity(String city, String postalCode, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper userMapper = new UserMapper(connectionPool);
        return userMapper.addCity(city, postalCode);
    }

}
