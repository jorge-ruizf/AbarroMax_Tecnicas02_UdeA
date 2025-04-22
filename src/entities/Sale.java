package entities;

import java.util.ArrayList;

public class Sale {
    private ArrayList<ProductSale> productSales;
    private int saleId;
    private int employeeId;
    private float discount;

    public Sale(ArrayList<ProductSale> productSales, int saleId, float discount) {
        this.productSales = productSales;
        this.saleId = saleId;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    public void addProduct(){
        //agregar producto
    }
    
    public float calculateSubtotalCost(){
        //buscar descuento
        return 0;
    }
    
    public float calculateTotalCost(){
        return 0;
    }
    
    public void printReceipt(){
        //imprimir recibo
    }
}
