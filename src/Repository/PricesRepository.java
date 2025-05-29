package Repository;

import com.mongodb.client.*;
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

}
