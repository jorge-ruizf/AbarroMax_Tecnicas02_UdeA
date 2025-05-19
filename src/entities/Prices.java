package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prices {

    private HashMap<Integer, HashMap<Integer, Price>> prices;

    public Prices(HashMap<Integer, HashMap<Integer, Price>> prices) {
        this.prices = prices;
    }

    public Prices() {
        this.prices = new HashMap<>();
    }

    public HashMap<Integer, HashMap<Integer, Price>> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, HashMap<Integer, Price>> prices) {
        this.prices = prices;
    }

    // Agregar un precio a un producto
    public void addPrice(int productId, int minQuantity, Price price) {
        if (!prices.containsKey(productId)) {
            prices.put(productId, new HashMap<>());
        }
        prices.get(productId).put(minQuantity, price);
    }

}
