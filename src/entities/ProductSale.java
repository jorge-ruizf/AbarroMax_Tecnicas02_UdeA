package entities;

public class ProductSale {
    private int productId;
    private int offerId;
    private int stock;

    public ProductSale(int productId, int offerId, int stock) {
        this.productId = productId;
        this.offerId = offerId;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public float calculateProductCost() {
        //logica para calcular el costo individual
        return 0;
    }
}
