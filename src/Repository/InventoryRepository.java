package repository;

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import entities.Inventory;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryRepository {
    private final MongoCollection<Document> collection;

    public InventoryRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.collection = database.getCollection("inventoryDB");
    }

    public Inventory getInventory() {
        Inventory inventory = new Inventory();

        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            int productId = doc.getInteger("productId");
            int quantity = doc.getInteger("currentQuantity");

            inventory.addProduct(productId, quantity);
        }

        return inventory;
    }
    
    
    public boolean updateInventory(Inventory inventory) {
        boolean updatedAny = false;

        for (Map.Entry<Integer, Integer> entry : inventory.getInventory().entrySet()) {
            int product = entry.getKey();
            int quantity = entry.getValue();

            Document query = new Document("productId", product);
            Document updatedData = new Document("$set", new Document("currentQuantity", quantity));

            UpdateResult result = collection.updateOne(query, updatedData);

            if (result.getModifiedCount() > 0) {
                updatedAny = true;
            }
        }

        return updatedAny;
    }
    
    public void clearInventory() {
        collection.deleteMany(new Document());
    }
    
    public void uploadInventory(Inventory inventory) {
        List<Document> documents = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : inventory.getInventory().entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            Document doc = new Document("productId", productId)
                    .append("currentQuantity", quantity);
            documents.add(doc);
        }

        if (!documents.isEmpty()) {
            collection.insertMany(documents);
        }
    }
}
