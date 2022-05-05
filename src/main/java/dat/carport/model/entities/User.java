package dat.carport.model.entities;

import java.util.Objects;

public class User
{
    private String username;
    private String email;
    private String password;
    private String tlfnr;
    private String address;
    private String city;

    public User(String username, String email, String password, String tlfnr, String adress, String city)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tlfnr = tlfnr;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tlfnr='" + tlfnr + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && email.equals(user.email) && password.equals(user.password) && tlfnr.equals(user.tlfnr) && address.equals(user.address) && city.equals(user.city);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, email, password, tlfnr, address, city);
    }
}
