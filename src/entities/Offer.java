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
    
    public boolean isAvailable() {
        return stock > 0;
    }

    // Aplica el descuento al precio original
    public float applyDiscount(float originalPrice) {
        return originalPrice * (1 - discount / 100);
    }

    // Reduce el stock en 1 si se realiza una venta con oferta
    public void useOffer() {
        if (stock > 0) {
            stock--;
        } else {
            System.out.println("La oferta ya no está disponible. Stock agotado.");
        }
    }

    // Muestra los detalles de la oferta
    public void showOfferDetails() {
        System.out.println("Oferta disponible:");
        System.out.println("- Stock con descuento: " + stock);
        System.out.println("- Descuento aplicado: " + discount + "%");
    }
}
    
    
