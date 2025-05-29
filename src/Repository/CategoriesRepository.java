package repository;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import entities.Categories;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

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
}
