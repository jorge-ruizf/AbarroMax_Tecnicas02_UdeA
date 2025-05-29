package repository;

import com.mongodb.client.*;
import entities.Product;
import org.bson.Document;

import java.util.ArrayList;

public class ProductRepository {
    private final MongoCollection<Document> collection;

    public ProductRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.collection = database.getCollection("productsDB");
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            int id = doc.getInteger("_id");
            String name = doc.getString("name");
            int categoryId = doc.getInteger("category");
            String supplier = doc.getString("brand");

            products.add(new Product(id, name, categoryId, supplier));
        }

        return products;
    }
}
