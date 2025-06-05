package main;

import models.*;
import services.SistemaEventos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();

      
        sistema.cadastrarCliente("Cleitinho", "cleito@eventos.com");

        
        Evento show = new Show("Rock Festival", LocalDate.of(2025, 5, 10), LocalDate.of(2025, 5, 12), 100.0, 1000);
        Evento congresso = new Congresso("Tech Talks", LocalDate.of(2025, 6, 1), LocalDate.of(2025, 6, 3), 80.0, 500);

        sistema.cadastrarEvento(show);
        sistema.cadastrarEvento(congresso);

        
        Cliente cliente = new Cliente("Maria", "maria@email.com");
        boolean comprado = sistema.comprarIngresso("Rock Festival", cliente, true);
        if (comprado) {
            System.out.println("Ingresso comprado com sucesso!");
        }

        
        double valor = sistema.calcularValorIngresso("Rock Festival", true);
        System.out.println("Valor do ingresso VIP para Rock Festival: R$" + valor);
    }
}
