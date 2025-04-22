package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Prices {
    private HashMap<Integer, ArrayList<Price>> prices;

    public Prices(HashMap<Integer, ArrayList<Price>> prices) {
        this.prices = prices;
    }

    public HashMap<Integer, ArrayList<Price>> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, ArrayList<Price>> prices) {
        this.prices = prices;
    }
    
    public void registerPrice() {
        // lógica para registrar un nuevo precio
    }

    public void addPrice(int productId, Price price) {
        // lógica para agregar un precio a un producto
    }
}