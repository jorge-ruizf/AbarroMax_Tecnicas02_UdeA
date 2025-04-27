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

    // Cálculo del costo total del producto con descuento aplicado
    public float calculateProductCost(float unitPrice, float discountPercent) {
        float discountAmount = (unitPrice * discountPercent) / 100;
        float finalUnitPrice = unitPrice - discountAmount;
        return finalUnitPrice * stock;
    }

    // Mostrar detalles de la venta del producto
    public void showProductSaleDetails(float unitPrice, float discountPercent) {
        System.out.println("Producto ID: " + productId);
        System.out.println("Oferta ID: " + offerId);
        System.out.println("Cantidad Vendida: " + stock);
        System.out.println("Precio Unitario: $" + unitPrice);
        System.out.println("Descuento: " + discountPercent + "%");
        System.out.println("Costo Total: $" + calculateProductCost(unitPrice, discountPercent));
    }
}


    