import java.util.*;

public class SistemaEventos {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarShow(String nome, Date inicio, Date fim, double valor, int capacidade) {
        eventos.add(new Show(nome, inicio, fim, valor, capacidade));
    }

    public void cadastrarCongresso(String nome, Date inicio, Date fim, double valor, int capacidade) {
        eventos.add(new Congresso(nome, inicio, fim, valor, capacidade));
    }

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println("Evento: " + e.getNome() + " | Dias: " + e.getNumeroDias() + " | Disponibilidade: " + e.temDisponibilidade());
        }
    }

    public boolean comprarIngresso(String nomeEvento, Cliente cliente, boolean vip) {
        for (Evento e : eventos) {
            if (e.getNome().equals(nomeEvento)) {
                if (e instanceof Show) {
                    return ((Show)e).adicionarParticipante(cliente, vip);
                } else {
                    return e.adicionarParticipante(cliente);
                }
            }
        }
        return false;
    }
}
