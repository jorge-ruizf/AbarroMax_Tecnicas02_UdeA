package entities;

import java.util.ArrayList;
import java.util.HashMap;

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
        categories.setCategories(categoriesStrings);
        
        
        products = new ArrayList<Product>();
        products.add(new Product(0, "Paracetamol", 0, "Colsubsidios"));
        products.add(new Product(1, "Papas 105g", 2, "Margarita"));
        products.add(new Product(2, "Jeans", 1, "Media Naranja"));

        
        price = new Prices();
        offers = new Offers();
        
        
        sales = new Sales();
        returns = new Returns();
        
              
        
        inventory = new Inventory();
        
        HashMap<Integer, Integer> inventoryTemp = new HashMap<>();
        inventoryTemp.put(0,3);
        inventoryTemp.put(1,5);
        inventoryTemp.put(2,2);
        
        inventory.setInventory(inventoryTemp);


        
        
        inventaryMovementHistory = new InventoryMovementHistory();     
    }
    
    public static void main() {
               
    }
    
}
