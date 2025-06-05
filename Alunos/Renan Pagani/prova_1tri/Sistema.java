package prova;

import java.util.*;

public class Sistema {
    private List<Evento> eventos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf)); 
    }

    public void cadastrarShow(String nome, int dias, double preco, int capacidade) {
        eventos.add(new Show(nome, dias, preco, capacidade));
    }

    public void cadastrarCongresso(String nome, int dias, double preco, int capacidade) {
        eventos.add(new Congresso(nome, dias, preco, capacidade));
    } 
   

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println("Evento: " + e.getNome() + " | Tipo: " + e.getClass().getSimpleName() +
                    " | Dias: " + e.getDias() + " | Valor diário: R$" + e.getPrecoDiario() +
                    " | Vagas disponíveis: " + e.getVagasDisponiveis());
        }
    }

    public void comprarIngresso(String cpf, String nomeEvento, boolean vip) {
        Cliente cliente = buscarCliente(cpf);
        Evento evento = buscarEvento(nomeEvento);

        if (cliente == null || evento == null) {
            System.out.println("Cliente ou evento não encontrado.");
            return;
        }

        if (!evento.temVaga()) {
            System.out.println("Evento sem vagas disponíveis.");
            return;
        }

        if (evento instanceof Show && vip && !((Show) evento).areaVipDisponivel()) {
            System.out.println("Área VIP indisponível.");
            return;
        }

        evento.adicionarParticipante(cliente);
        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        ingressos.add(ingresso);
        evento.registrarIngresso(ingresso); 
        System.out.println("Ingresso comprado por " + cliente.getNome() + " - Valor: R$" + ingresso.getValor());
    }

    public void utilizarIngresso(String cpf, String nomeEvento) {
        for (Ingresso i : ingressos) {
        	if (i.getCliente().getCpf().equals(cpf) && i.getEvento().getNome().equals(nomeEvento)) {
                i.utilizarIngresso();
                return;
            }
        }
        System.out.println("Ingresso não encontrado.");
    }

    private Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    private Evento buscarEvento(String nome) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nome)) return e;
        }
        return null;
    }
}