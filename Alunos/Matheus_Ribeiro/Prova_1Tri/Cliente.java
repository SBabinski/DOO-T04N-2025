package sistema;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    String name;
    String email;
    List<Ingresso> ingressos = new ArrayList<>();

    public Cliente(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addIngresso(Evento evento, Boolean isVip) {
        ingressos.add(new Ingresso(evento, isVip));
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso encontrado.");
            return;
        }

        System.out.println("Ingressos de " + name + " (" + email + "):");
        for (Ingresso ingresso : ingressos) {
            System.out.println("Evento: " + ingresso.evento.title + " - Usado: " + (ingresso.isUsed ? "Sim" : "Não"));
        }
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }

    public class Ingresso {
        Evento evento;
        boolean isVip;
        boolean isUsed;

        public Ingresso(Evento evento, boolean isVip) {
            this.evento = evento;
            this.isVip = isVip;
            this.isUsed = false;
        }

        public void usarIngresso() {
            if (!isUsed) {
                isUsed = true;
                System.out.println("Ingresso " + (isVip ? "VIP " : "") + "para " + evento.title + " foi marcado como usado.");
            } else {
                System.out.println("Este ingresso já foi utilizado.");
            }
        }

        @Override
        public String toString() {
            return "Evento: " + evento.title + 
                   " | VIP: " + (isVip ? "Sim" : "Não") +
                   " | Usado: " + (isUsed ? "Sim" : "Não");
        }
    }

}

