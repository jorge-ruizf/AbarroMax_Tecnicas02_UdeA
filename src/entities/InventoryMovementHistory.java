package entities;

import java.text.SimpleDateFormat;
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

    // Agregar un nuevo movimiento
    public void addInventoryMovement(InventoryMovement movement) {
        this.inventoryMovementHistory.add(movement);
    }

    // Generar un reporte de todos los movimientos
    public void report() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("----- Reporte de Movimientos de Inventario -----");
        if (inventoryMovementHistory.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (InventoryMovement movement : inventoryMovementHistory) {
            System.out.println("Fecha del movimiento: " + formatter.format(movement.getDate()));
            movement.printStatus();
            System.out.println("-------------------------------------------");
        }
    }
}
