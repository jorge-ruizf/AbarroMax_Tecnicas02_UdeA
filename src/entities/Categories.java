package entities;

import java.util.ArrayList;

public class Categories {
    private ArrayList<String> categories;

    public Categories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void registerCategory() {
        // pedir un string
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }
}
