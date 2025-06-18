package repository;

import com.mongodb.client.*;
import entities.Categories;
import org.bson.Document;
import com.mongodb.client.model.Updates;

import java.util.List;

public class CategoriesRepository {
    private final MongoCollection<Document> collection;

    public CategoriesRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.collection = database.getCollection("categoriesDB");
    }

    public Categories getCategories() {
        Categories categories = new Categories();

        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            List<String> categoryList = doc.getList("categories", String.class);
            if (categoryList != null) {
                for (String category : categoryList) {
                    categories.addCategory(category);
                }
            }
        }

        return categories;
    }
    
    public void addCategory(String category) {
        collection.updateOne(
            new Document(),
            Updates.addToSet("categories", category)
        );
    }

    public void deleteCategory(String category) {
        collection.updateOne(
            new Document(),
            Updates.pull("categories", category)
        );
    }

}
