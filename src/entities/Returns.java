package entities;


import java.util.ArrayList;

public class Returns {
    private ArrayList<Sale> returns;

    public Returns() {
    }

    public Returns(ArrayList<Sale> returns) {
        this.returns = returns;
    }

    public ArrayList<Sale> getReturns() {
        return returns;
    }

    public void setReturns(ArrayList<Sale> returns) {
        this.returns = returns;
    }

    // Agrega una nueva devolución
    public void addReturn(Sale sale) {
        returns.add(sale);
        System.out.println("Devolución registrada correctamente.");
    }

    // Imprime las últimas 5 devoluciones (o menos si no hay tantas)
    public void printLastesReturns() {
        System.out.println("Últimas devoluciones:");
        int count = Math.min(5, returns.size());
        for (int i = returns.size() - count; i < returns.size(); i++) {
            System.out.println("[" + i + "] " + returns.get(i).toString());
        }
    }

    // Imprime la devolución en la posición indicada
    public void printReturns(int index) {
        if (index >= 0 && index < returns.size()) {
            System.out.println("Devolución #" + index + ":");
            System.out.println(returns.get(index).toString());
        } else {
            System.out.println("Índice de devolución no válido.");
        }
    }
}
