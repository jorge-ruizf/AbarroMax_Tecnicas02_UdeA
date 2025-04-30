package entities;


import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Sale implements Transaction {
    private ArrayList<ProductSale> productSales;
    private int saleId;
    private String employeeName;
    private float discount;
    private float total;
    private Date date;

    public Sale() {
        this.productSales = new ArrayList<ProductSale>();
        this.saleId = 0;
        this.employeeName = "";
        this.discount = 0;
        this.total = 0;
        this.date = new Date();
    }

    public Sale(ArrayList<ProductSale> productSales, int saleId, String employeeName, float discount) {
        this.productSales = productSales;
        this.saleId = saleId;
        this.employeeName = employeeName;
        this.discount = discount;
        this.date = new Date();
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public float getDiscount() {
        return discount;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void addProduct(ProductSale ps) {
        productSales.add(ps);
    }
    
    public void removeProductById(int id) {
        for (ProductSale ps : productSales) {
            if (ps.getProductId() == id) {
                productSales.remove(ps);
                break;
            }
        }
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
    
    public String getProductSalesAsString() {
        String text = "";
        for (ProductSale ps : productSales) {
            text = text.concat("Product ID: " + ps.getProductId() + ", Offer: " + ps.getOffer() + ", Stock: " + ps.getStock() + "\n");
        }
        return text;
    }

    public void printReceipt() {
        System.out.println("=== RECIBO DE VENTA ===");
        System.out.println("Venta ID: " + saleId);
        System.out.println("Empleado: " + employeeName);
        System.out.println("Fecha: " + employeeName);
        System.out.println("Productos:");
        for (ProductSale ps : productSales) {
            System.out.println("- Producto ID: " + ps.getProductId() + 
                               " | Cantidad: " + ps.getStock());
        }
        System.out.println("Subtotal: $" + calculateSubtotalCost());
        System.out.println("Descuento aplicado: " + discount + "%");
        System.out.println("Total a pagar: $" + calculateTotalCost());
        System.out.println("=========================");
    }
    
    
    
    @Override
    public double calculateAmount() {
        return (double) calculateTotalCost();
    }
    
}

