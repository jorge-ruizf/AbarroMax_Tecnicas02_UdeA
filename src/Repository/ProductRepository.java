package repository;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
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

    public void addProduct(Product product) {
        Document doc = new Document("_id", product.getId())
                .append("name", product.getName())
                .append("category", product.getCategoryId())
                .append("brand", product.getSupplier());

        collection.insertOne(doc);
    }

    public boolean deleteProductById(int id) {
        Document query = new Document("_id", id);
        DeleteResult result = collection.deleteOne(query);
        // Si se elimino la cantidad de productos eliminados sera mayor a 0 (true)
        return result.getDeletedCount() > 0;
    }

    public boolean updateProduct(Product product) {
        Document query = new Document("_id", product.getId());

        Document updatedData = new Document("$set", new Document("name", product.getName())
                .append("category", product.getCategoryId())
                .append("brand", product.getSupplier()));

        UpdateResult result = collection.updateOne(query, updatedData);
        // Si se modifico la cantidad de productos modificados sera mayor a 0 (true)
        return result.getModifiedCount() > 0;
    }
}
