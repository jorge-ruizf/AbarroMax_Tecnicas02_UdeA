package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;

public class AbarroMax {
    
    public static Inventory inventory;
    public static ArrayList<Product> products;
    public static Categories categories ;
    public static Prices prices;
    public static Offers offers;
    public static InventoryMovementHistory inventaryMovementHistory;
    public static Sales sales;
    public static Returns returns;
    
    static {
        
        categories = new Categories();
        ArrayList<String> categoriesStrings = new ArrayList();
        categoriesStrings.add("Medicine");
        categoriesStrings.add("Clothes");
        categoriesStrings.add("Consumables");
        categoriesStrings.add("Technologic");
        categoriesStrings.add("Home");
        categories.setCategories(categoriesStrings);
        
        
        products = new ArrayList<Product>();
        products.add(new Product(0, "Paracetamol", 0, "Colsubsidios"));
        products.add(new Product(1, "Papas 105g", 2, "Margarita"));
        products.add(new Product(2, "Jeans", 1, "Media Naranja"));
        products.add(new Product(3, "Laptop 14 pulgadas", 3, "Lenovo"));
        products.add(new Product(4, "Sofá cama", 4, "Home Elements"));
        products.add(new Product(5, "Auriculares Bluetooth", 3, "Sony"));
        products.add(new Product(6, "Camiseta básica", 1, "Koaj"));
        products.add(new Product(7, "Detergente líquido 2L", 4, "Ariel"));
        products.add(new Product(8, "Smartphone 128GB", 3, "Samsung"));
        products.add(new Product(9, "Zapatos deportivos", 1, "Nike"));
        products.add(new Product(10, "Pastillas de menta", 0, "Halls"));
        products.add(new Product(11, "Papel higiénico 12 rollos", 4, "Familia"));
        products.add(new Product(12, "Monitor 24 pulgadas", 3, "LG"));
        products.add(new Product(13, "Chaqueta impermeable", 1, "North Face"));
        products.add(new Product(14, "Aspiradora robot", 4, "iRobot"));

               
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
        
        offers = new Offers();
        
        
        sales = new Sales();
        returns = new Returns();
        
        
        // Inventarios
                     
        InventoryMovementHistory inventaryMovementHistoryTemp = new InventoryMovementHistory();
        
        
        Calendar calendar = Calendar.getInstance();
        
        HashMap<Integer, Integer> inventoryTemp = new HashMap<>();
        inventoryTemp.put(0,10);
        inventoryTemp.put(1,20);
        inventoryTemp.put(2,6);
        
        calendar.set(2025, Calendar.APRIL, 22, 15, 15, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date base_date = calendar.getTime();
        
        inventaryMovementHistoryTemp.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), base_date));
        
        
        inventoryTemp.put(3,12);
        inventoryTemp.put(4,8);
        inventoryTemp.put(5,35);
        
        calendar.set(2025, Calendar.APRIL, 25, 9, 50, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        base_date = calendar.getTime();
        
        inventaryMovementHistoryTemp.addInventoryMovement(new InventoryMovement(new HashMap<>(inventoryTemp), base_date));
        
        
        inventoryTemp.put(6,10);
        inventoryTemp.put(7,20);
        inventoryTemp.put(8,5);
        
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
