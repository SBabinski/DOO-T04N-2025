package prova1tri;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaEventos {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();

 
    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }


    public void cadastrarShow(String nome, LocalDate inicio, LocalDate fim, double preco, int capacidade, double adicionalVIP) {
        eventos.add(new Show(nome, inicio, fim, preco, capacidade, adicionalVIP));
    }


    public void cadastrarCongresso(String nome, LocalDate inicio, LocalDate fim, double preco, int capacidade) {
        eventos.add(new Congresso(nome, inicio, fim, preco, capacidade));
    }

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println("Evento: " + e.getNome());
            System.out.println("Duração: " + e.getDuracao() + " dias");
            System.out.println("Valor diário: R$" + String.format("%.2f", e.precoDiario));
            System.out.println("Valor total das diárias: R$" + String.format("%.2f", e.precoDiario * e.getDuracao()));
            if (e instanceof Show) {
                Show show = (Show) e;
                System.out.println("Valor diário com VIP: R$" + String.format("%.2f", show.calcularValorVIP()));
            }
            System.out.println();
        }
    }

    public void listarEventosComIndice() {
        for (int i = 0; i < eventos.size(); i++) {
            Evento e = eventos.get(i);
            System.out.println(i + " - " + e.getNome() + " | " + e.getDuracao() + " dias | R$" + e.calcularValorIngresso());
        }
    }

    public Evento getEventoPorIndice(int indice) {
        if (indice >= 0 && indice < eventos.size()) {
            return eventos.get(indice);
        }
        return null;
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public boolean comprarIngresso(String nomeEvento, String cpfCliente, boolean vip) {
        Cliente cliente = buscarCliente(cpfCliente);
        if (cliente == null) return false;

        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nomeEvento)) {
                if (e instanceof Show && vip) {
                    return ((Show) e).comprarVIP(cliente);
                } else {
                    return e.adicionarParticipante(cliente);
                }
            }
        }
        return false;
    }
}
