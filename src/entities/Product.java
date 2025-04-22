package entities;

public class Product {
    private int id;
    private String name;
    private int categoryId;
    private String supplier;
    
    public Product(int id, String name, int categoryId, String supplier) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
