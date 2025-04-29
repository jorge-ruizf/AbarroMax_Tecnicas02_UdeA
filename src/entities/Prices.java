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

    // Registrar un nuevo precio desde consola
    public void registerPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();

        System.out.print("Ingrese la cantidad mínima para este precio: ");
        int minQuantity = scanner.nextInt();

        System.out.print("Ingrese el precio por esta cantidad: ");
        float priceValue = scanner.nextFloat();

        System.out.print("Ingrese el stock disponible: ");
        int stock = scanner.nextInt();

        Price newPrice = new Price(stock, priceValue);
        addPrice(productId, minQuantity, newPrice);
    }

    // Agregar un precio a un producto
    public void addPrice(int productId, int minQuantity, Price price) {
        if (!prices.containsKey(productId)) {
            prices.put(productId, new HashMap<>());
        }
        prices.get(productId).put(minQuantity, price);
        System.out.println("Precio agregado para el producto ID: " + productId + " con cantidad mínima: " + minQuantity);
    }

    // Mostrar todos los precios por producto
    public void showAllPrices() {
        if (prices.isEmpty()) {
            System.out.println("No hay precios registrados. Comuníquese con soporte.");
            return;
        }

        System.out.println("=== Precios Registrados ===");
        for (Map.Entry<Integer, HashMap<Integer, Price>> entry : prices.entrySet()) {
            int productId = entry.getKey();
            System.out.println("Producto ID: " + productId);

            HashMap<Integer, Price> productPrices = entry.getValue();
            for (Map.Entry<Integer, Price> priceEntry : productPrices.entrySet()) {
                int minQuantity = priceEntry.getKey();
                Price price = priceEntry.getValue();
                System.out.println("Cantidad mínima: " + minQuantity);
                price.showPriceDetails();
            }
            System.out.println("---------------------------");
        }
    }

    // Obtener los precios de un producto específico
    public HashMap<Integer, Price> getPricesByProduct(int productId) {
        return prices.getOrDefault(productId, new HashMap<>());
    }

    // Buscar el precio más bajo de un producto (opcional)
    public float getLowestPrice(int productId) {
        HashMap<Integer, Price> productPrices = prices.get(productId);
        if (productPrices == null || productPrices.isEmpty()) {
            return -1;
        }

        float minPrice = Float.MAX_VALUE;
        for (Price price : productPrices.values()) {
            if (price.getPrice() < minPrice) {
                minPrice = price.getPrice();
            }
        }
        return minPrice;
    }
}
