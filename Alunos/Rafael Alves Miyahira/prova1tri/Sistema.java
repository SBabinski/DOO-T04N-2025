package prova1tri;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Evento> eventos = new ArrayList<>();
    private ArrayList<Ingresso> ingressos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();  // Lista para armazenar clientes

    public void cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + nome);
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            evento.exibirDetalhes();
            System.out.println();
        }
    }

    public void comprarIngresso(Evento evento, Cliente cliente, int dias) {
        if (evento.verificarDisponibilidade()) {
            evento.adicionarParticipante(cliente);
            Ingresso ingresso = new Ingresso(evento, cliente, dias);
            ingressos.add(ingresso);
            System.out.println("Ingresso comprado com sucesso para o evento " + evento.nome);
        } else {
            System.out.println("Não há mais vagas disponíveis para este evento.");
        }
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.nome.equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }
}
