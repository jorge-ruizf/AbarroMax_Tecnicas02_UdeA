package entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Prices {
    private HashMap<Integer, ArrayList<Price>> prices;

    public Prices(HashMap<Integer, ArrayList<Price>> prices) {
        this.prices = prices;
    }

    public Prices() {
        this.prices = new HashMap<>();
    }

    public HashMap<Integer, ArrayList<Price>> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, ArrayList<Price>> prices) {
        this.prices = prices;
    }

    // Registrar un nuevo precio desde consola
    public void registerPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();

        System.out.print("Ingrese el precio del producto: ");
        float price = scanner.nextFloat();

        System.out.print("Ingrese el stock disponible: ");
        int stock = scanner.nextInt();

        Price newPrice = new Price(stock, price);
        addPrice(productId, newPrice);
    }

    // Agregar un precio a un producto
    public void addPrice(int productId, Price price) {
        if (!prices.containsKey(productId)) {
            prices.put(productId, new ArrayList<>());
        }
        prices.get(productId).add(price);
        System.out.println("Precio agregado al producto ID: " + productId);
    }

    // Mostrar todos los precios por producto
    public void showAllPrices() {
        if (prices.isEmpty()) {
            System.out.println("No hay precios registrados.");
            return;
        }

        System.out.println("=== Precios Registrados ===");
        for (Integer productId : prices.keySet()) {
            System.out.println("Producto ID: " + productId);
            ArrayList<Price> productPrices = prices.get(productId);
            for (Price p : productPrices) {
                p.showPriceDetails();
            }
            System.out.println("---------------------------");
        }
    }

    // Obtener la lista de precios de un producto específico
    public ArrayList<Price> getPricesByProduct(int productId) {
        return prices.getOrDefault(productId, new ArrayList<>());
    }

    // Buscar el precio más bajo de un producto (opcional)
    public float getLowestPrice(int productId) {
        ArrayList<Price> list = prices.get(productId);
        if (list == null || list.isEmpty()) return -1;

        float min = list.get(0).getPrice();
        for (Price p : list) {
            if (p.getPrice() < min) {
                min = p.getPrice();
            }
        }
        return min;
    }
}
