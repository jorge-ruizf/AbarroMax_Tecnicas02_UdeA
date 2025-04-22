package entities;

import java.util.ArrayList;

public class InventoryMovementHistory {
    private ArrayList<InventoryMovement> inventoryMovementHistory;

    public InventoryMovementHistory(ArrayList<InventoryMovement> inventoryMovementHistory) {
        this.inventoryMovementHistory = inventoryMovementHistory;
    }

    public ArrayList<InventoryMovement> getInventoryMovementHistory() {
        return inventoryMovementHistory;
    }

    public void setInventoryMovementHistory(ArrayList<InventoryMovement> inventoryMovementHistory) {
        this.inventoryMovementHistory = inventoryMovementHistory;
    }

    public void addInventoryMovement() {
        // lógica para agregar un nuevo movimiento
    }

    public void report() {
        // lógica para generar un reporte (ej. varianza)
    }
}