import java.util.ArrayList;

public class SistemaEventos {
    public ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Evento> eventos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.cpf.equals(cpf)) return c;
        }
        return null;
    }

    public Evento buscarEvento(String nome) {
        for (Evento e : eventos) {
            if (e.nome.equalsIgnoreCase(nome)) return e;
        }
        return null;
    }

    public boolean comprarIngresso(String nomeEvento, String cpf, boolean vip) {
        Cliente cliente = buscarCliente(cpf);
        Evento evento = buscarEvento(nomeEvento);

        if (cliente == null || evento == null) return false;

        if (vip && evento.tipo.equals("show") && !evento.temVagaVIP()) return false;

        Ingresso ingresso = new Ingresso(cliente, vip);
        return evento.adicionarIngresso(ingresso);
    }

    public boolean usarIngresso(String nomeEvento, String cpf) {
        Evento evento = buscarEvento(nomeEvento);
        if (evento == null) return false;

        for (Ingresso i : evento.ingressos) {
            if (i.cliente.cpf.equals(cpf) && !i.usado) {
                i.usar();
                return true;
            }
        }
        return false;
    }
}
