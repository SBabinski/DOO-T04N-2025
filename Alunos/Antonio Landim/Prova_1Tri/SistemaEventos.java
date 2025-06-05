package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaEventos {
    private List<Cliente> clientes;
    private List<Evento> eventos;
    private List<Ingresso> ingressos;

    public SistemaEventos() {
        clientes = new ArrayList<>();
        eventos = new ArrayList<>();
        ingressos = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarShow(String nome, Date inicio, Date fim, double valorDiario, int capacidade) {
        eventos.add(new Show(nome, inicio, fim, valorDiario, capacidade));
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) return e;
        }
        return null;
    }

    public boolean comprarIngresso(String cpf, String nomeEvento, boolean vip, Date dataCompra) {
        Cliente cliente = buscarClientePorCpf(cpf);
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (cliente == null || evento == null) return false;

      
        if (evento instanceof Show && vip) {
            long countVip = ingressos.stream().filter(i -> i.getEvento().equals(evento) && i.isVip()).count();
            int vagasVip = ((Show) evento).getVagasVip();
            if (countVip >= vagasVip) return false;
        }

        if (evento.getNumeroParticipantes() >= evento.getCapacidade()) return false;

        if (evento.adicionarParticipante(cliente)) {
            Ingresso ingresso = new Ingresso(cliente, evento, vip, dataCompra);
            ingressos.add(ingresso);
            return true;
        }

        return false;
    }

    public boolean usarIngresso(String cpf, String nomeEvento) {
        for (Ingresso i : ingressos) {
            if (i.getCliente().getCpf().equals(cpf) &&
                i.getEvento().getNome().equalsIgnoreCase(nomeEvento) &&
                !i.isUtilizado()) {
                i.usarIngresso();
                return true;
            }
        }
        return false;
    }

    public List<Ingresso> listarIngressos() {
        return ingressos;
    }
}
