package Repository;

import com.mongodb.client.*;
import entities.InventoryMovement;
import entities.InventoryMovementHistory;
import org.bson.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InventoryMovementRepository {
    private final MongoCollection<Document> collection;

    public InventoryMovementRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.collection = database.getCollection("inventoryMovementsDB");
    }

    public InventoryMovementHistory getInventoryMovements() {
        InventoryMovementHistory history = new InventoryMovementHistory();
        FindIterable<Document> docs = collection.find();

        for (Document doc : docs) {
            HashMap<Integer, Integer> inventory = new HashMap<>();
            List<Document> changes = (List<Document>) doc.get("changes");

            for (Document change : changes) {
                Integer productId = change.getInteger("productId");
                Integer quantity = change.getInteger("newQuantity");
                inventory.put(productId, quantity);
            }

            // Convertir la fecha
            String dateStr = doc.getString("date");
            Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse(dateStr);
            } catch (ParseException e) {
                date = new Date(); // Si hay error, usar fecha actual
            }

            InventoryMovement movement = new InventoryMovement(inventory, date);
            history.addInventoryMovement(movement);
        }

        return history;
    }
}
