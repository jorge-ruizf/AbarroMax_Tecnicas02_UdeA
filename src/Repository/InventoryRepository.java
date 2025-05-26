package repository;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import entities.Inventory;
import entities.Product;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

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
}
