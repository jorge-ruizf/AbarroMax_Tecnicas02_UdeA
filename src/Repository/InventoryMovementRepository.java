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
    
    public void addInventoryMovement(HashMap<Integer, Integer> inventory) {
        // Preparar la lista de cambios (inventario actual)
        List<Document> changes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            Document changeDoc = new Document("productId", entry.getKey())
                                     .append("newQuantity", entry.getValue());
            changes.add(changeDoc);
        }

        // Formatear la fecha actual en formato ISO 8601
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").format(new Date());

        // Crear el documento para insertar en MongoDB
        Document doc = new Document()
                .append("date", formattedDate)
                .append("movementId", collection.countDocuments() + 1)
                .append("changes", changes);

        collection.insertOne(doc);
    }

}
