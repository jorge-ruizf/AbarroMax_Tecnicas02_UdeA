package entities;

import java.util.HashMap;
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

    // Registrar un nuevo producto al inventario
    public void registerProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();

        if (inventory.containsKey(productId)) {
            System.out.println("El producto ya está registrado.");
            return;
        }

        System.out.print("Ingrese la cantidad inicial: ");
        int quantity = scanner.nextInt();

        inventory.put(productId, quantity);
        System.out.println("Producto registrado con éxito.");
    }

    // Agregar cantidad a un producto existente
    public void addProduct(int productId, int quantity) {
        if (inventory.containsKey(productId)) {
            int currentQty = inventory.get(productId);
            inventory.put(productId, currentQty + quantity);
            System.out.println("Se agregó " + quantity + " unidades al producto ID " + productId + ".");
        } else {
            System.out.println("El producto no está registrado. Use 'registerProduct' primero.");
        }
    }

    // Gestión básica por consola: sumar, restar, eliminar
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
    public void printStockStatus() {
        System.out.println("=== Estado Actual del Inventario ===");
        if (inventory.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Integer productId : inventory.keySet()) {
                System.out.println("Producto ID: " + productId + " | Cantidad: " + inventory.get(productId));
            }
        }
    }
}