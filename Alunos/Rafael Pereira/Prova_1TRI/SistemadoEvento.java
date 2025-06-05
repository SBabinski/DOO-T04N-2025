package fag;

import java.util.ArrayList;
import java.util.List;

public class SistemadoEvento {
    private List<Evento> eventos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    // Adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Buscar cliente por CPF
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    // Cadastrar evento
    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    // Buscar evento por nome
    public Evento buscarEventoPorNome(String nome) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) return e;
        }
        return null;
    }

    // Listar eventos
    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println("Evento: " + e.getNome() + " | Participantes: " + e.getParticipantes().size());
        }
    }

    // Listar eventos detalhados
    public void listarEventosDetalhados() {
        for (Evento e : eventos) {
            System.out.println("\n--- Evento ---");
            System.out.println("Nome: " + e.getNome());
            System.out.println("Duração: " + e.getDuracaoDias() + " dias");
            System.out.println("Preço por dia: R$" + e.getPrecoPorDia());
            System.out.println("Capacidade: " + e.getCapacidade());
            System.out.println("Participantes: " + e.getParticipantes().size());
        }
    }

    // Calcular valor do ingresso
    public double calcularValorIngresso(String nomeEvento, boolean vip) {
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento != null) {
            return evento.calcularValorIngresso(vip);
        }
        return 0;
    }

    // Comprar ingresso
    public boolean comprarIngresso(String nomeEvento, Cliente cliente, boolean vip) {
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento == null) return false;

        if (vip && evento instanceof Show) {
            Show show = (Show) evento;
            if (show.getVagasVipDisponiveis() > 0) {
                return show.adicionarParticipante(new ClienteVip(cliente.getNome(), cliente.getCpf()));
            } else {
                return false;
            }
        } else {
            return evento.adicionarParticipante(cliente);
        }
    }
}
