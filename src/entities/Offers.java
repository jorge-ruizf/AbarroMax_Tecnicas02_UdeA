/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Offers {
    private HashMap<Integer, ArrayList<Offer>> prices;

    public Offers(HashMap<Integer, ArrayList<Offer>> prices) {
        this.prices = prices;
    }

    public HashMap<Integer, ArrayList<Offer>> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<Integer, ArrayList<Offer>> prices) {
        this.prices = prices;
    }

    public void registerOffer() {
        // lógica para registrar una nueva oferta
    }

    public void addOffer(Offer offer) {
        // lógica para agregar una oferta
    }

    public void removeOffer(Offer offer) {
        // lógica para eliminar una oferta
    }
}