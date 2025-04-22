package entities;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Integer> inventory;

    public Inventory(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }

    public HashMap<Integer, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }
    
    public void registerProduct() {
        // lógica para registrar un nuevo producto en el inventario
    }

    public void addProduct(int productId, int quantity) {
        // lógica para agregar cantidad de un producto existente
    }

    public void manageProducts() {
        // lógica para gestionar los productos del inventario
    }

    public void printStockStatus() {
        // lógica para imprimir el estado actual del stock
    }
}