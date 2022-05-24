package dat.carport.dtos;

import java.util.Locale;
import java.util.Objects;

public class StockListeDTO {
    long stockid;
    String description;
    String length;
    String unit;
    String price_per_unit;

    public StockListeDTO(long stockid, String description, int length, String unit, double price_per_unit) {
        this.stockid = stockid;
        this.description = description;
        setLength(length);
        this.unit = unit;
        setPrice_per_unit(price_per_unit);
    }

    private void setLength(int length) {
        if (length != 0) {
            this.length = String.format(Locale.ENGLISH, "%d", length);
        } else {
            this.length = "";
        }
    }

    private void setPrice_per_unit(double price_per_unit) {
        String priceS = String.format(Locale.ENGLISH, "%f", price_per_unit);
        String[] priceArr = priceS.split("\\.");
        if (priceArr[1].equals("0")) {
            this.price_per_unit = String.format(Locale.ENGLISH, "%s", priceArr[0]);
        } else {
            this.price_per_unit = String.format(Locale.ENGLISH, "%s.%s", priceArr[0], priceArr[1]);
        }
    }

    public long getStockid() {
        return stockid;
    }

    public String getDescription() {
        return description;
    }

    public String getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }

    public String getPrice_per_unit() {
        return price_per_unit;
    }

    @Override
    public String toString() {
        return "StockListeDto{" +
                "stockid=" + stockid +
                ", description='" + description + '\'' +
                ", length=" + length +
                ", unit='" + unit + '\'' +
                ", price_per_unit=" + price_per_unit +
                '}';
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getStockid(), getDescription(), getLength(), getUnit(), getPrice_per_unit());
    }
}


