package dat.carport.persistence;

import dat.carport.model.entities.City;
import dat.carport.model.entities.User;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.services.UserFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest
{
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/carport_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass() {
            connectionPool = new ConnectionPool(USER, PASSWORD, URL);
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection()) {
            try (Statement stmt = testConnection.createStatement() ) {
                // Remove all rows from all tables
                stmt.execute("delete from user");
                stmt.execute("delete from city");
                stmt.execute("ALTER TABLE user AUTO_INCREMENT = 1");
                // Indsæt et par brugere
                stmt.execute("insert into city (city, postal_code) " +
                        "values ('Nyker','3700')," +
                        "('Valby','2500'), " +
                        "('Østermarie','3751')");
                stmt.execute("insert into user (username, email, password, tlfnr, address, city, isAdmin) " +
                        "values ('user','u@u.dk','1234','12345678','Kirkemarksvej 48','Nyker',0)," +
                        "('adam','a@a.dk','1234','12345678','Bodil Ipsens vej 4','Valby',0), " +
                        "('ben','b@b.dk','1234','12345678','Lundsvej 12','Østermarie',0)");
                stmt.execute("insert into user (username, email, password, tlfnr, isAdmin)" +
                        "value ('admin','admin@fog.dk','1234','12345678',1)");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }

    @Test
    void login() throws DatabaseException
    {
        User expectedUser = new User("user", "u@u.dk", "1234", "12345678", "Kirkemarksvej 48", "Nyker", "user");
        expectedUser.setId(1);
        User actualUser = UserFacade.login("user","1234", connectionPool);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void invalidPasswordLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> UserFacade.login("user","123", connectionPool));
    }

    @Test
    void invalidUserNameLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> UserFacade.login("bob","1234", connectionPool));
    }

    @Test
    void createUser() throws DatabaseException
    {
        User newUser = UserFacade.createUser("jill", "test@mail.com", "1234", "88888888", "testvej 28", "testby", connectionPool);
        User logInUser = UserFacade.login("jill","1234", connectionPool);
        User expectedUser = new User("jill", "test@mail.com", "1234", "88888888", "testvej 28", "testby", "user");
        expectedUser.setId(5);
        assertEquals(expectedUser, newUser);
        assertEquals(expectedUser, logInUser);

    }

    @Test
    void addCity() throws DatabaseException {
        City existingCity = UserFacade.addCity("Nyker", "3700", connectionPool);
        City expe1 = new City("Nyker", "3700");
        assertEquals(expe1, existingCity);

        City newCity = UserFacade.addCity("Aakirkeby", "3720", connectionPool);
        City expe2 = new City("Aakirkeby", "3720");
        assertEquals(expe2, newCity);
    }
}