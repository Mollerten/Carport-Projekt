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
    private String role;

    public User(String username, String email, String password, String tlfnr, String role)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tlfnr = tlfnr;
        this.role = role;
    }

    public User(String username, String email, String password, String tlfnr, String address, String city, String role)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tlfnr = tlfnr;
        this.address = address;
        this.city = city;
        this.role = role;
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
                ", isAdmin='" + role + '\'' +
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTlfnr()
    {
        return tlfnr;
    }

    public void setTlfnr(String tlfnr)
    {
        this.tlfnr = tlfnr;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && email.equals(user.email) && password.equals(user.password) && tlfnr.equals(user.tlfnr) && address.equals(user.address) && city.equals(user.city) && role.equals(user.role);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, email, password, tlfnr, address, city, role);
    }
}
