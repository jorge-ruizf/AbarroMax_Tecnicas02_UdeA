package entities;

public class Product {

    private int id;
    private String name;
    private int categoryId;
    private String supplier;

    public Product() {

    }

    public Product(int id, String name, int categoryId, String supplier) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        if (categoryId > 0) {
            this.categoryId = categoryId;
        } else {
            System.out.println("ID de categoría inválido.");
        }
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        if (!supplier.isEmpty()) {
            this.supplier = supplier;
        } else {
            System.out.println("El proveedor no puede estar vacío.");
        }
    }

}

