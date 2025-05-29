package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private HashMap<Integer, Integer> inventory;

    public Inventory(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public HashMap<Integer, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }
    
    public void addProduct(int productId, int quantity) {
        if (!inventory.containsKey(productId)) {
            inventory.put(productId, quantity);
        } else {
            System.out.println("El producto ya está registrado. Use 'quantityChangeProduct' primero.");
        }
    }

    // Agregar cantidad a un producto existente
    public void quantityChangeProduct(int productId, int quantity) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, quantity);
            System.out.println("Se agregó " + quantity + " unidades al producto ID " + productId + ".");
        } else {
            System.out.println("El producto no está registrado. Use 'registerProduct' primero.");
        }
    }

    // Seccionar cada una de estas funciones
    public void manageProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a gestionar: ");
        int productId = scanner.nextInt();

        if (!inventory.containsKey(productId)) {
            System.out.println("El producto no está en el inventario.");
            return;
        }

        System.out.println("1. Sumar existencias");
        System.out.println("2. Restar existencias");
        System.out.println("3. Eliminar producto");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Cantidad a agregar: ");
                int add = scanner.nextInt();
                inventory.put(productId, inventory.get(productId) + add);
                System.out.println("Cantidad actualizada.");
                break;
            case 2:
                System.out.print("Cantidad a restar: ");
                int sub = scanner.nextInt();
                int current = inventory.get(productId);
                if (sub <= current) {
                    inventory.put(productId, current - sub);
                    System.out.println("Cantidad actualizada.");
                } else {
                    System.out.println("No hay suficiente inventario para restar esa cantidad.");
                }
                break;
            case 3:
                inventory.remove(productId);
                System.out.println("Producto eliminado del inventario.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Mostrar estado actual del stock
    public String printStockStatus() {
        String text = new String();
        text = text.concat("=== Actual Inventory Status ===\n");
        if (inventory.isEmpty()) {
            text = text.concat("The inventory is void");
        } else {
            for (Integer productId : inventory.keySet()) {
                text = text.concat("ID: " + productId + " | Stock: " + inventory.get(productId) + "\n");
            }
        }
        return text;
    }

    public String printReportStock(ArrayList<Product> products) {
        String text = "";

        for (Map.Entry<Integer, Integer> entry : this.inventory.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            Product product = products.get(key);

            if (value < 5) {
                text = text.concat("ID: " + key + " | Name: " + product.getName() + " is close to running out\n");
            } else if (value > 30) {
                text = text.concat("ID: " + key + " | Name: " + product.getName() + " is overstocked\n");
            }
        }

        return text;
    }
    
    public String printInventoryForCategorie(int selectedCategorie, String selectedName, ArrayList<Product> products, Categories categories){
        String text = "";        
        HashMap<Integer, Integer> inventory = this.getInventory();

        // Recorrer el HashMap
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            // Mostrar
            Product product = products.get(key);
            String categorie = categories.getCategories().get(product.getCategoryId());
            
            if (selectedCategorie == -1 || product.getCategoryId() == selectedCategorie) {
                if (selectedName.equals("") || product.getName().toLowerCase().contains(selectedName.toLowerCase())) {
                    text = text.concat("ID: " + key + " | Name: " + product.getName() + " | Categorie: " + categorie + " | Stock: " + value + " | Suplieer: " + product.getSupplier() + "\n");
                }
            }
        }
        if (text.equals("")) {
            text = text.concat("The inventory is void!");
        }
        
        return text;
    }
    
    public String printInventoryCatalog(int selectedCategorie, String selectedName, ArrayList<Product> products, Categories categories, Prices prices){
        String text = "";

        // Recorrer el HashMap
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            // Mostrar
            Product product = products.get(key);
            String categorie = categories.getCategories().get(product.getCategoryId());
            
            if (selectedCategorie == -1 || product.getCategoryId() == selectedCategorie) {
                if (selectedName.equals("") || product.getName().toLowerCase().contains(selectedName.toLowerCase())) {
                    
                    // Construir pricesTemps
                    String priceText = "";
                    HashMap<Integer, Price> productPrices = prices.getPrices().get(key);

                    if (productPrices != null) {
                        for (Map.Entry<Integer, Price> priceEntry : productPrices.entrySet()) {
                            int minQuantity = priceEntry.getKey();
                            Price priceObj = priceEntry.getValue();

                            priceText = priceText.concat(minQuantity + " x $" + String.format("%.2f", priceObj.getPrice()) + ", ");
                        }
                        if (priceText.length() > 2) {
                            priceText = priceText.substring(0, priceText.length() - 2);
                        }
                    } else {
                        priceText = priceText.concat("No prices available");
                    }
                    text = text.concat("ID: " + key + " | Name: " + product.getName() + " | Categorie: " + categorie + " | Stock: " + value + " | Suplieer: " + product.getSupplier() + " | Prices: " + priceText + "\n");
                }
            }   
        }
        
        if (text.equals("")) {
            text = text.concat("The inventory is void!");
        }
        
        return text;
    }
    
}
