package lucas.PROVA_1TRI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    public Cliente cadastrarCliente(String nomeCompleto, String cpf) {
        Cliente c = new Cliente(nomeCompleto, cpf);
        clientes.add(c);
        return c;
    }

    public Evento cadastrarEvento(int tipo, String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        Evento e = (tipo == 1)
            ? new Show(nome, inicio, fim, precoDiario, capacidade)
            : new Congresso(nome, inicio, fim, precoDiario, capacidade);
        eventos.add(e);
        return e;
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Evento buscarEventoPorNome(String nome) {
        return eventos.stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}


