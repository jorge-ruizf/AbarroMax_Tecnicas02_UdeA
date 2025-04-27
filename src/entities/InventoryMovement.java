package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InventoryMovement {
    private HashMap<Integer, Integer> inventory;
    private Date date;

    public InventoryMovement(HashMap<Integer, Integer> inventory, Date date) {
        this.inventory = inventory;
        this.date = date;
    }

    // Constructor alternativo: si no se pasa fecha, se toma la fecha actual
    public InventoryMovement(HashMap<Integer, Integer> inventory) {
        this.inventory = inventory;
        this.date = new Date(); // Se registra la fecha actual automáticamente
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

    // Método para mostrar el estado del movimiento
    public void printStatus() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Fecha del movimiento: " + formatter.format(date));
        System.out.println("Detalles del movimiento:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            System.out.println("Producto ID: " + entry.getKey() + " | Cantidad: " + entry.getValue());
        }
    }
}

