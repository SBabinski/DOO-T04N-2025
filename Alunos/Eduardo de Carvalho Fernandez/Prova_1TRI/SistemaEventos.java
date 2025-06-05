package eventos;

import java.util.HashSet;
import java.util.Set;

public class SistemaEventos {
    private Set<Cliente> clientes = new HashSet<>();
    private Set<Evento> eventos = new HashSet<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public Evento buscarEvento(String nome) {
        for (Evento e : eventos) {
            if (e.GetNome().equalsIgnoreCase(nome)) {
                return e;
            }
        }
        return null;
    }

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println(e.getTipo() + " - " + e.GetNome());
        }
    }
}
