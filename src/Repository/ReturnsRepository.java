package Repository;

import com.mongodb.client.*;
import org.bson.Document;
import entities.ProductSale;
import entities.Sale;
import entities.Sales;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReturnsRepository {
    private final MongoCollection<Document> salesCollection;

    public ReturnsRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.salesCollection = database.getCollection("salesDB");
    }

    public Sales getSales() {
        Sales sales = new Sales();
        //ArrayList<Sale> sales = new ArrayList<>();

        FindIterable<Document> docs = salesCollection.find();
        for (Document doc : docs) {
            int saleId = doc.getInteger("saleId");
            String customerName = doc.getString("customerName");
            int discount = doc.getInteger("discount");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            Date date = Date.valueOf(LocalDate.parse(doc.getString("date"), formatter));

            ArrayList<ProductSale> products = new ArrayList<>();
            for (Document p : doc.getList("productSales", Document.class)) {
                int productId = p.getInteger("productId");
                int quantity = p.getInteger("quantity");
                int offer = p.getInteger("offer");
                products.add(new ProductSale(productId, offer, quantity));
            }

            sales.addSale(new Sale(products, saleId, customerName, discount, date));
        }

        return sales;
    }
}