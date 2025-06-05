
import java.util.*;

class SistemaEventos {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarShow(String nome, int dias, double valor, int capacidade) {
        eventos.add(new Show(nome, dias, valor, capacidade));
    }

    public void cadastrarCongresso(String nome, int dias, double valor, int capacidade) {
        eventos.add(new Congresso(nome, dias, valor, capacidade));
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento.getTipo() + ": " + evento.getNome());
        }
    }

    public void listarShows() {
        for (Evento evento : eventos) {
            if (evento instanceof Show) {
                System.out.println("Show: " + evento.getNome());
            }
        }
    }

    public void listarCongressos() {
        for (Evento evento : eventos) {
            if (evento instanceof Congresso) {
                System.out.println("Congresso: " + evento.getNome());
            }
        }
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println("Cliente: " + c.getNome());
        }
    }

    public void verificarDisponibilidadeEvento(String nomeEvento) {
        Evento evento = eventos.stream().filter(e -> e.getNome().equals(nomeEvento)).findFirst().orElse(null);
        if (evento != null) {
            int disponiveis = evento.getCapacidade() - evento.participantes.size();
            System.out.println("Ingressos disponíveis para " + nomeEvento + ": " + disponiveis);
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    public void comprarIngresso(String nomeCliente, String nomeEvento, boolean vip) {
        Cliente cliente = clientes.stream().filter(c -> c.getNome().equals(nomeCliente)).findFirst().orElse(null);
        Evento evento = eventos.stream().filter(e -> e.getNome().equals(nomeEvento)).findFirst().orElse(null);

        if (cliente == null || evento == null) {
            System.out.println("Cliente ou evento não encontrado.");
            return;
        }

        if (!evento.verificarDisponibilidade()) {
            System.out.println("Evento lotado.");
            return;
        }

        if (vip && !(evento instanceof Show)) {
            System.out.println("Ingresso VIP disponível apenas para shows.");
            return;
        }

        if (vip && evento instanceof Show show) {
            if (!show.verificarDisponibilidadeVIP()) {
                System.out.println("Área VIP lotada.");
                return;
            }
        }

        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        ingressos.add(ingresso);
        System.out.println("Ingresso comprado! Valor: R$" + ingresso.getValor());
    }

    public void usarIngresso(String nomeCliente, String nomeEvento) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.cliente.getNome().equals(nomeCliente) && ingresso.evento.getNome().equals(nomeEvento)) {
                ingresso.usarIngresso();
                return;
            }
        }
        System.out.println("Ingresso não encontrado.");
    }
}

