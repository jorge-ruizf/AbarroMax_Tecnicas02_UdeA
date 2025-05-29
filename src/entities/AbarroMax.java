package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;


import com.mongodb.client.MongoClient;
import repository.MongoConnection;
import repository.ProductRepository;


public class AbarroMax {
    

    public static Inventory inventory;
    public static ArrayList<Product> products;
    public static Categories categories;
    public static Prices prices;
    public static InventoryMovementHistory inventaryMovementHistory;
    public static Sales sales;
    public static Returns returns;

    static {
        // Inicializamos Prices
        prices = new Prices();

        // Creando los precios manualmente
        HashMap<Integer, Price> priceMap;

        // Precio de ejemplo para cada producto
        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 10.50f)); // Precio unitario de 1
        priceMap.put(5, new Price(5, 9.80f));  // Mayoreo de 5 unidades a 9.80
        priceMap.put(10, new Price(10, 9.00f)); // Mayoreo de 10 unidades a 9.00
        prices.getPrices().put(0, priceMap); // Producto 0: Paracetamol

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 4.20f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 3.90f)); // Mayoreo de 3 unidades a 3.90
        priceMap.put(6, new Price(6, 3.50f)); // Mayoreo de 6 unidades a 3.50
        prices.getPrices().put(1, priceMap); // Producto 1: Papas 105g

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 45.00f)); // Precio unitario de 1
        priceMap.put(2, new Price(2, 42.00f)); // Mayoreo de 2 unidades a 42.00
        priceMap.put(5, new Price(5, 40.00f)); // Mayoreo de 5 unidades a 40.00
        prices.getPrices().put(2, priceMap); // Producto 2: Jeans

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 600.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 580.00f)); // Mayoreo de 3 unidades a 580.00
        priceMap.put(7, new Price(7, 550.00f)); // Mayoreo de 7 unidades a 550.00
        prices.getPrices().put(3, priceMap); // Producto 3: Laptop 14 pulgadas

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 1200.00f)); // Precio unitario de 1
        priceMap.put(2, new Price(2, 1150.00f)); // Mayoreo de 2 unidades a 1150.00
        priceMap.put(5, new Price(5, 1100.00f)); // Mayoreo de 5 unidades a 1100.00
        prices.getPrices().put(4, priceMap); // Producto 4: Sofá cama

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 250.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 230.00f)); // Mayoreo de 3 unidades a 230.00
        priceMap.put(5, new Price(5, 220.00f)); // Mayoreo de 5 unidades a 220.00
        prices.getPrices().put(5, priceMap); // Producto 5: Auriculares Bluetooth

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 25.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 23.00f)); // Mayoreo de 3 unidades a 23.00
        priceMap.put(6, new Price(6, 21.50f)); // Mayoreo de 6 unidades a 21.50
        prices.getPrices().put(6, priceMap); // Producto 6: Camiseta básica

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 18.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 17.00f)); // Mayoreo de 3 unidades a 17.00
        priceMap.put(6, new Price(6, 15.50f)); // Mayoreo de 6 unidades a 15.50
        prices.getPrices().put(7, priceMap); // Producto 7: Detergente líquido 2L

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 700.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 680.00f)); // Mayoreo de 3 unidades a 680.00
        priceMap.put(7, new Price(7, 650.00f)); // Mayoreo de 7 unidades a 650.00
        prices.getPrices().put(8, priceMap); // Producto 8: Smartphone 128GB

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 130.00f)); // Precio unitario de 1
        priceMap.put(3, new Price(3, 125.00f)); // Mayoreo de 3 unidades a 125.00
        priceMap.put(6, new Price(6, 120.00f)); // Mayoreo de 6 unidades a 120.00
        prices.getPrices().put(9, priceMap); // Producto 9: Zapatos deportivos

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 2.50f));  // Precio unitario de 1
        priceMap.put(3, new Price(3, 2.20f));  // Mayoreo de 3 unidades a 2.20
        priceMap.put(6, new Price(6, 2.00f));  // Mayoreo de 6 unidades a 2.00
        prices.getPrices().put(10, priceMap);  // Producto 10: Pastillas de menta

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 15.00f));  // Precio unitario de 1
        priceMap.put(3, new Price(3, 13.50f));  // Mayoreo de 3 unidades a 13.50
        priceMap.put(5, new Price(5, 12.50f));  // Mayoreo de 5 unidades a 12.50
        prices.getPrices().put(11, priceMap);  // Producto 11: Papel higiénico 12 rollos

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 350.00f));  // Precio unitario de 1
        priceMap.put(2, new Price(2, 330.00f));  // Mayoreo de 2 unidades a 330.00
        priceMap.put(5, new Price(5, 300.00f));  // Mayoreo de 5 unidades a 300.00
        prices.getPrices().put(12, priceMap);  // Producto 12: Monitor 24 pulgadas

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 200.00f));  // Precio unitario de 1
        priceMap.put(3, new Price(3, 190.00f));  // Mayoreo de 3 unidades a 190.00
        priceMap.put(6, new Price(6, 180.00f));  // Mayoreo de 6 unidades a 180.00
        prices.getPrices().put(13, priceMap);  // Producto 13: Chaqueta impermeable

        priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, 1300.00f));  // Precio unitario de 1
        priceMap.put(2, new Price(2, 1250.00f));  // Mayoreo de 2 unidades a 1250.00
        priceMap.put(5, new Price(5, 1200.00f));  // Mayoreo de 5 unidades a 1200.00
        prices.getPrices().put(14, priceMap);  // Producto 14: Aspiradora robot

        //Venta de productos Individuales
        ProductSale ps1 = new ProductSale(1, 10, 5);
        ProductSale ps2 = new ProductSale(2, 0, 3);
        ProductSale ps3 = new ProductSale(3, 5, 2);
        ProductSale ps4 = new ProductSale(4, 20, 1);
        ProductSale ps5 = new ProductSale(5, 15, 4);
        ProductSale ps6 = new ProductSale(6, 0, 6);
        ProductSale ps7 = new ProductSale(7, 25, 2);
        ProductSale ps8 = new ProductSale(8, 5, 7);
        ProductSale ps9 = new ProductSale(9, 30, 1);
        ProductSale ps10 = new ProductSale(10, 10, 3);
        ProductSale ps11 = new ProductSale(11, 0, 8);
        ProductSale ps12 = new ProductSale(12, 20, 3);
        ProductSale ps13 = new ProductSale(13, 0, 2);
        ProductSale ps14 = new ProductSale(14, 20, 5);

        returns = new Returns(new ArrayList<Sale>());
        returns.addReturn(sales.removeSaleById(9));

        // Inventarios
        InventoryMovementHistory inventaryMovementHistoryTemp = new InventoryMovementHistory();

        Calendar calendar = Calendar.getInstance();

        HashMap<Integer, Integer> inventoryTemp = new HashMap<>();
        inventoryTemp.put(0, 10);
        inventoryTemp.put(1, 20);
        inventoryTemp.put(2, 6);

        calendar.set(2025, Calendar.APRIL, 22, 15, 15, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date base_date = calendar.getTime();

        inventaryMovementHistoryTemp.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), base_date));

        inventoryTemp.put(3, 12);
        inventoryTemp.put(4, 8);
        inventoryTemp.put(5, 35);

        calendar.set(2025, Calendar.APRIL, 25, 9, 50, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        base_date = calendar.getTime();

        inventaryMovementHistoryTemp.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), base_date));

        inventoryTemp.put(6, 10);
        inventoryTemp.put(7, 20);
        inventoryTemp.put(8, 5);
        inventoryTemp.put(9, 5);
        inventoryTemp.put(10, 40);
        inventoryTemp.put(11, 20);
        inventoryTemp.put(12, 1);
        inventoryTemp.put(13, 3);
        inventoryTemp.put(14, 2);

        calendar.set(2025, Calendar.APRIL, 28, 16, 30, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        base_date = calendar.getTime();

        inventaryMovementHistoryTemp.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), base_date));

        inventory = new Inventory(inventoryTemp);
        inventaryMovementHistory = new InventoryMovementHistory(inventaryMovementHistoryTemp.getInventoryMovementHistory());
    }

    public static void main() {

    }

}
