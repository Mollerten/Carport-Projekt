package dat.carport.model.entities;

import dat.carport.dtos.Material;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class PartsList {
    ArrayList<Material> materials = new ArrayList<>();

    int rafterCount;
    int request_id;
    double priceInDKK;

    public PartsList(int request_id) {
        this.request_id = request_id;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void updatePrice() {
        priceInDKK = 0;
        for (Material mat : materials) {
            priceInDKK += mat.getPrice();
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        priceInDKK = Double.parseDouble(df.format(priceInDKK));
    }

    public int getRafterCount()
    {
        return rafterCount;
    }

    public void setRafterCount(int rafterCount)
    {
        this.rafterCount = rafterCount;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public double getPriceInDKK() {
        return priceInDKK;
    }

    public void setPriceInDKK(double priceInDKK) {
        this.priceInDKK = priceInDKK;
    }
}
