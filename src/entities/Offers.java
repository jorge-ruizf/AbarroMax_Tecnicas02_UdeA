/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Offers {
    private HashMap<Integer, ArrayList<Offer>> prices;

    public Offers(HashMap<Integer, ArrayList<Offer>> prices) {
        this.prices = prices;
    }

    public Offers() {
        this.prices = new HashMap<>();
    }

    public HashMap<Integer, ArrayList<Offer>> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, ArrayList<Offer>> prices) {
        this.prices = prices;
    }

    // Registrar una nueva oferta desde consola
    public void registerOffer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();

        System.out.print("Ingrese el stock para la oferta: ");
        int stock = scanner.nextInt();

        System.out.print("Ingrese el descuento (%): ");
        float discount = scanner.nextFloat();

        Offer newOffer = new Offer(stock, discount);
        addOffer(productId, newOffer);
    }

    // Agregar una oferta a un producto
    public void addOffer(int productId, Offer offer) {
        if (!prices.containsKey(productId)) {
            prices.put(productId, new ArrayList<>());
        }
        prices.get(productId).add(offer);
        System.out.println("Oferta agregada al producto ID: " + productId);
    }

    // Eliminar una oferta específica de un producto
    public void removeOffer(int productId, Offer offer) {
        if (prices.containsKey(productId)) {
            ArrayList<Offer> offers = prices.get(productId);
            if (offers.remove(offer)) {
                System.out.println("Oferta eliminada del producto ID: " + productId);
            } else {
                System.out.println("No se encontró la oferta especificada para ese producto.");
            }
            if (offers.isEmpty()) {
                prices.remove(productId);
            }
        } else {
            System.out.println("No hay ofertas registradas para ese producto.");
        }
    }

    // Mostrar todas las ofertas
    public void showAllOffers() {
        if (prices.isEmpty()) {
            System.out.println("No hay ofertas activas.");
            return;
        }

        System.out.println("=== Ofertas por Producto ===");
        for (Integer productId : prices.keySet()) {
            System.out.println("Producto ID: " + productId);
            ArrayList<Offer> offers = prices.get(productId);
            for (Offer offer : offers) {
                offer.showOfferDetails();
            }
            System.out.println("----------------------------");
        }
    }

    // Obtener todas las ofertas de un producto específico
    public ArrayList<Offer> getOffersByProduct(int productId) {
        return prices.getOrDefault(productId, new ArrayList<>());
    }
}
