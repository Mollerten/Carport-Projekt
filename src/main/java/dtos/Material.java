package dtos;

import dat.carport.model.config.ApplicationStart;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.AdminMapper;
import dat.carport.model.services.AdminFacade;
import dat.carport.model.services.UserFacade;

import java.io.Serializable;
import java.util.Objects;

public class Material implements Serializable {
    double stockID;
    String description;
    int amount;
    int length;
    String unit;
    String helpText;
    double

    public Material(String description, int amount, int length, String unit, String helpText) {
        this.description = description;
        this.amount = amount;
        this.length = length;
        this.unit = unit;
        this.helpText = helpText;
        try {
            setStockID(AdminFacade.hentStockIdFraDescOgLength(description, length, ApplicationStart.getConnectionPool()));
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
    }

    public double getStockID() {
        return stockID;
    }

    public void setStockID(double stockID) {
        this.stockID = stockID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return getStockID() == material.getStockID() && getAmount() == material.getAmount() &&
                getDescription().equals(material.getDescription()) && getLength() == (material.getLength()) &&
                getUnit().equals(material.getUnit()) && getHelpText().equals(material.getHelpText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStockID(), getDescription(), getAmount(), getLength(), getUnit(), getHelpText());
    }

    @Override
    public String toString() {
        return "Material{" +
                "stockID=" + stockID +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", length='" + length + '\'' +
                ", unit='" + unit + '\'' +
                ", helpText='" + helpText + '\'' +
                '}';
    }
}
