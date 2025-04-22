package entities;

public class Offer {
    private int stock;
    private float discount;

    public Offer(int stock, float discount) {
        this.stock = stock;
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    
}