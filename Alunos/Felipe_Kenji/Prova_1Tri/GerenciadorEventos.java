import java.util.ArrayList;
import java.util.List;

public class GerenciadorEventos {
    private List<Evento> eventos;
    public GerenciadorEventos() {
        eventos = new ArrayList<>();
    }
    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }
    public List<Evento> getEventos() {
        return eventos;
    }
    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Não há eventos cadastrados.");
        } else {
            for (Evento evento : eventos) {
                System.out.println("Nome: " + evento.getNome() + " | Dias: " + evento.getDias() + " | Vagas: " + evento.getVagas());
        }
     }
    }
    public boolean comprarIngresso(Cliente cliente, Evento evento) {
        return evento.adicionarParticipante(cliente);
    }
    public double calcularValorIngresso(Evento evento, Cliente cliente) {
        double valorTotal = evento.getValorDiario() * evento.getDias();
        if (evento instanceof Show) {
            double adicionalVIP = valorTotal * 0.10;
            valorTotal += adicionalVIP;
        }
        return valorTotal;
    }
}
