package dtos;

import java.util.Objects;

public class StockListeDTO {
    int stockid;
    String description;
    int amount;
    String unit;
    int price_per_unit;

    public StockListeDTO(int stockid, String description, int amount, String unit, int price_per_unit) {
        this.stockid = stockid;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
        this.price_per_unit = price_per_unit;
    }

    public int getStockid() {
        return stockid;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public int getPrice_per_unit() {
        return price_per_unit;
    }

    @Override
    public String toString() {
        return "StockListeDto{" +
                "stockid=" + stockid +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", price_per_unit=" + price_per_unit +
                '}';
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getStockid(), getDescription(), getAmount(), getUnit(), getPrice_per_unit());
    }
}


