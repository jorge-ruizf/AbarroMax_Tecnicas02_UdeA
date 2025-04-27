package entities;

public class Price {
    private int stock;
    private float price;

    public Price(int stock, float price) {
        this.stock = stock;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Verifica si hay suficiente stock disponible
    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    // Reduce el stock después de una venta
    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("No hay suficiente stock para completar la venta.");
        }
    }

    // Calcula el total a pagar por una cantidad
    public float calculateTotal(int quantity) {
        return price * quantity;
    }

    // Muestra detalles del precio
    public void showPriceDetails() {
        System.out.println("Precio por unidad: $" + price);
        System.out.println("Stock disponible: " + stock);
    }
}
