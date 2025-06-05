package classes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GerenciadorEventos sistema = new GerenciadorEventos();

        
        Show show1 = new Show("Lollapalooza", new Date(), new Date(System.currentTimeMillis() + 2 * 86400000L), 200.0, 100);
        Congresso congresso1 = new Congresso("TechSummit", new Date(), new Date(System.currentTimeMillis() + 1 * 86400000L), 150.0, 50);
        sistema.cadastrarEvento(show1);
        sistema.cadastrarEvento(congresso1);

        
        System.out.println("\n=== Comprando Ingressos ===");
        sistema.comprarIngresso(); 
    }
}
