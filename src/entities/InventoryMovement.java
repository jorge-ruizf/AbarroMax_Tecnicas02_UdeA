package entities;

import java.util.Date;
import java.util.HashMap;

public class InventoryMovement {
    private HashMap<Integer, Integer> inventory;
    private Date date;

    public InventoryMovement(HashMap<Integer, Integer> inventory, Date date) {
        this.inventory = inventory;
        this.date = date;
    }

    public InventoryMovement(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }

    public HashMap<Integer, Integer> getInventory() {
        return inventory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInventory(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
    }

    public void printStatus() {
        // lógica para mostrar el estado del movimiento
    }
}
