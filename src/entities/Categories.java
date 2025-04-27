package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Categories {
    private ArrayList<String> categories;

   
    public Categories() {
        this.categories = new ArrayList<>();
    }

   
    public Categories(ArrayList<String> categories) {
        this.categories = categories;
    }

    
    public ArrayList<String> getCategories() {
        return categories;
    }

   
    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    // Registrar una nueva categoría desde la entrada del usuario
    public void registerCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la nueva categoría: ");
        String category = scanner.nextLine().trim();

        if (category.isEmpty()) {
            System.out.println("La categoría no puede estar vacía.");
        } else if (categories.contains(category)) {
            System.out.println("La categoría ya existe.");
        } else {
            categories.add(category);
            System.out.println("Categoría '" + category + "' registrada exitosamente.");
        }
    }

    // Agregar una categoría directamente (sin preguntar)
    public void addCategory(String category) {
        if (!categories.contains(category)) {
            this.categories.add(category);
        }
    }
}


