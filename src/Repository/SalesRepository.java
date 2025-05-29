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


public class SalesRepository {
    private final MongoCollection<Document> salesCollection;

    public SalesRepository(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("AbarroMaxDB");
        this.salesCollection = database.getCollection("salesDB");
    }
    
    public Sales getReturns() {
        Sales sales = new Sales();
        FindIterable<Document> docs = salesCollection.find();
        for (Document doc : docs) {
            if(!doc.getBoolean("return")){
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
        }

        return sales;
    }
    
    public void addSale(Sale sale) {
        Document saleDoc = new Document()
            .append("saleId", sale.getSaleId())
            .append("customerName", sale.getEmployeeName())
            .append("discount", sale.getDiscount())
            .append("date", new SimpleDateFormat("dd-MM-yyyy").format(sale.getDate()))
            .append("return", false);

        ArrayList<Document> productDocs = new ArrayList<>();
        for (ProductSale ps : sale.getProductSales()) {
            Document p = new Document()
                .append("productId", ps.getProductId())
                .append("quantity", ps.getStock())
                .append("offer", ps.getOffer());
            productDocs.add(p);
        }

        saleDoc.append("productSales", productDocs);
        salesCollection.insertOne(saleDoc);
    }
    
    // ------------------------------------- RETURNS -----------------------------------------------------------

    public Sales getSales() {
        Sales sales = new Sales();
        FindIterable<Document> docs = salesCollection.find();
        for (Document doc : docs) {
            if(doc.getBoolean("return")){
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
        }

        return sales;
    }

    public void addReturn(Sale sale) {
        Document returnDoc = new Document()
            .append("saleId", sale.getSaleId())
            .append("customerName", sale.getEmployeeName())
            .append("discount", sale.getDiscount())
            .append("date", new SimpleDateFormat("dd-MM-yyyy").format(sale.getDate()))
            .append("return", true);

        ArrayList<Document> productDocs = new ArrayList<>();
        for (ProductSale ps : sale.getProductSales()) {
            Document p = new Document()
                .append("productId", ps.getProductId())
                .append("quantity", ps.getStock())
                .append("offer", ps.getOffer());
            productDocs.add(p);
        }

        returnDoc.append("productSales", productDocs);
        salesCollection.insertOne(returnDoc);
    }

}