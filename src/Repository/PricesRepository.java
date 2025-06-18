package Repository;

import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entities.Price;
import entities.Prices;
import org.bson.Document;
import java.util.List;

public class PricesRepository {
    private final MongoCollection<Document> collection;

    public PricesRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.collection = database.getCollection("pricesDB");
    }

    public Prices getPrices() {
        Prices prices = new Prices();

        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            Integer productId = doc.getInteger("product_id");

            List<Document> priceList = (List<Document>) doc.get("prices");
            if (priceList != null) {
                for (Document priceDoc : priceList) {
                    int stock = priceDoc.getInteger("quantity");

                    Object priceObj = priceDoc.get("price");
                    float priceValue;
                    if (priceObj instanceof Double) {
                        priceValue = ((Double) priceObj).floatValue();
                    } else if (priceObj instanceof Integer) {
                        priceValue = ((Integer) priceObj).floatValue();
                    } else {
                        priceValue = 0f;
                    }

                    Price price = new Price(stock, priceValue);
                    prices.addPrice(productId, stock, price);
                }
            }
        }

        return prices;
    }
    
    public void upsertPrice(int productId, int quantity, float price) {
        // Verifica si ya existe un documento con ese product_id y esa cantidad
        Document filter = new Document("product_id", productId)
                .append("prices.quantity", quantity);

        // Si existe esa cantidad, actualiza el precio
        UpdateResult result = collection.updateOne(
            filter,
            Updates.set("prices.$.price", price)
        );

        // Si no se actualizó nada (porque no existía), agregamos la cantidad y precio
        if (result.getMatchedCount() == 0) {
            // Verificamos si el product_id ya existe
            Document productFilter = new Document("product_id", productId);

            Document newPrice = new Document("quantity", quantity)
                    .append("price", price);

            UpdateOptions options = new UpdateOptions().upsert(true);

            collection.updateOne(
                productFilter,
                Updates.push("prices", newPrice),
                options
            );
        }
    }
    
    public void deletePrice(int productId, int quantity) {
        Document filter = new Document("product_id", productId);
        Document priceToRemove = new Document("quantity", quantity);

        collection.updateOne(
            filter,
            Updates.pull("prices", priceToRemove)
        );
    }



}
