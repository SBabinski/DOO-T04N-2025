package evento;

import java.util.ArrayList;

public class EventoService {
    private ArrayList<Evento> eventos = new ArrayList<>();

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento cadastrado: " + evento.getNome());
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println("Evento: " + evento.getNome() + " | Dias: " + evento.getDias() + " | Vagas: " + evento.getCapacidadeMaxima());
        }
    }

    public Ingresso comprarIngresso(Evento evento, Cliente cliente, boolean vip) {
        if (evento.podeParticipar()) {
            evento.adicionarParticipante();
            Ingresso ingresso = new Ingresso(evento, cliente, vip);
            System.out.println("Ingresso comprado para " + cliente.getNome() + " no evento " + evento.getNome());
            return ingresso;
        } else {
            System.out.println("Evento lotado!");
            return null;
        }
    }
}
