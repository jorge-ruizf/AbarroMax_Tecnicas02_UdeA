package entities;


import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private ArrayList<ProductSale> productSales;
    private int saleId;
    private int employeeId;
    private float discount; // descuento general en %

    public Sale(ArrayList<ProductSale> productSales, int saleId, int employeeId, float discount) {
        this.productSales = productSales;
        this.saleId = saleId;
        this.employeeId = employeeId;
        this.discount = discount;
    }

    public ArrayList<ProductSale> getProductSales() {
        return productSales;
    }

    public void setProductSales(ArrayList<ProductSale> productSales) {
        this.productSales = productSales;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void addProduct(ProductSale ps) {
        productSales.add(ps);
        System.out.println("Producto agregado a la venta.");
    }

    public float calculateSubtotalCost() {
        float subtotal = 0;
        for (ProductSale ps : productSales) {
            // Suponemos que los datos de precio y descuento se obtienen externamente
            float dummyPrice = 1000f; // Este valor debería obtenerse desde Prices
            float dummyDiscount = 0f; // Este valor debería venir desde Offers

            subtotal += ps.calculateProductCost(dummyPrice, dummyDiscount);
        }
        return subtotal;
    }

    public float calculateTotalCost() {
        float subtotal = calculateSubtotalCost();
        float discountAmount = subtotal * (discount / 100f);
        return subtotal - discountAmount;
    }

    public void printReceipt() {
        System.out.println("=== RECIBO DE VENTA ===");
        System.out.println("Venta ID: " + saleId);
        System.out.println("Empleado ID: " + employeeId);
        System.out.println("Productos:");
        for (ProductSale ps : productSales) {
            System.out.println("- Producto ID: " + ps.getProductId() + 
                               " | Oferta ID: " + ps.getOfferId() +
                               " | Cantidad: " + ps.getStock());
        }
        System.out.println("Subtotal: $" + calculateSubtotalCost());
        System.out.println("Descuento aplicado: " + discount + "%");
        System.out.println("Total a pagar: $" + calculateTotalCost());
        System.out.println("=========================");
    }

    Date getSaleDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

