package dat.carport.model.entities;

import java.util.Objects;

public class City
{
    private String city;
    private String postalCode;

    public City (String city, String postalCode)
    {
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String toString()
    {
        return "City{" +
                "city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && postalCode.equals(city1.postalCode);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(city, postalCode);
    }
}

