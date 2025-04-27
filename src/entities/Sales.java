package entities;

import java.util.ArrayList;
import java.util.Date;

public class Sales {
    private ArrayList<Sale> sales;

    public Sales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    // Imprime el recibo de la venta más reciente
    public void printLastesReceipt() {
        if (!sales.isEmpty()) {
            Sale lastSale = sales.get(sales.size() - 1);
            lastSale.printReceipt();
        } else {
            System.out.println("No hay ventas registradas.");
        }
    }

    // Imprime el recibo de la venta en el índice indicado
    public void printReceipt(int index) {
        if (index >= 0 && index < sales.size()) {
            Sale sale = sales.get(index);
            sale.printReceipt();
        } else {
            System.out.println("Índice de venta no válido.");
        }
    }

    // Devolver toda la venta (lógica de devolución de una venta completa)
    public void returnSale(int index) {
        if (index >= 0 && index < sales.size()) {
            sales.remove(index);
            System.out.println("Venta devuelta correctamente.");
        } else {
            System.out.println("Índice de venta no válido para devolución.");
        }
    }

    // Devolver un solo producto dentro de una venta
    public void returnOneSale(int productId) {
        boolean productFound = false;
        for (Sale sale : sales) {
            for (ProductSale productSale : sale.getProductSales()) {
                if (productSale.getProductId() == productId) {
                    sale.getProductSales().remove(productSale);
                    System.out.println("Producto con ID " + productId + " devuelto.");
                    productFound = true;
                    break;
                }
            }
            if (productFound) break;
        }
        if (!productFound) {
            System.out.println("Producto no encontrado en ninguna venta.");
        }
    }

    // Imprime el tiempo transcurrido entre la primera y última venta registrada
    public void printTimelapse() {
        if (!sales.isEmpty()) {
            Sale firstSale = sales.get(0);
            Sale lastSale = sales.get(sales.size() - 1);
            Date firstDate = firstSale.getSaleDate(); // Asumimos que la clase Sale tiene una fecha
            Date lastDate = lastSale.getSaleDate();
            long timeDifference = lastDate.getTime() - firstDate.getTime();
            long daysDifference = timeDifference / (1000 * 60 * 60 * 24); // Convertimos a días
            System.out.println("Tiempo transcurrido entre la primera y última venta: " + daysDifference + " días.");
        } else {
            System.out.println("No hay ventas registradas.");
        }
    }
}
