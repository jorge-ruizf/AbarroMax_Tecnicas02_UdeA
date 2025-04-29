package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;

public class AbarroMax {
    
    public static Inventory inventory;
    public static ArrayList<Product> products;
    public static Categories categories ;
    public static Prices price;
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

        
        price = new Prices();
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
