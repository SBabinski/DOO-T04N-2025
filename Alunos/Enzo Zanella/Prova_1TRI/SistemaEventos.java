package sistema_eventos;

import java.util.ArrayList;

public class SistemaEventos {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();
    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public Ingresso comprarIngresso(String cpf, String nomeEvento, boolean vip) {
        Cliente cliente = null;
        Evento evento = null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nomeEvento)) {
                evento = e;
                break;
            }
        }

        if (cliente == null || evento == null) {
            System.out.println("Cliente ou evento não encontrado.");
            return null;
        }

        if (evento instanceof Show && vip) {
            int vipLimite = (int) (evento.getCapacidadeMaxima() * 0.1);
            int vipAtual = 0;
            for (Ingresso i : ingressos) {
                if (i.getEvento().equals(evento) && i.isVip()) {
                    vipAtual++;
                }
            }

            if (vipAtual >= vipLimite) {
                System.out.println("Vagas VIP esgotadas.");
                return null;
            }
        }

        if (!evento.verificarDisponibilidade()) {
            System.out.println("Evento lotado.");
            return null;
        }

        if (!evento.adicionarParticipante(cliente)) {
            System.out.println("Erro ao adicionar participante.");
            return null;
        }

        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        ingressos.add(ingresso);
        return ingresso;
    }

    public void usarIngresso(String cpf, String nomeEvento) {
        for (Ingresso i : ingressos) {
            if (i.getEvento().getNome().equalsIgnoreCase(nomeEvento) && i.getCliente().getCpf().equals(cpf)) {
                if (i.utilizar()) {
                    System.out.println("Ingresso utilizado com sucesso.");
                } else {
                    System.out.println("Ingresso já foi utilizado.");
                }
                return;
            }
        }
        System.out.println("Ingresso não encontrado.");
    }

    
    public void usarIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            System.out.println("Ingresso inválido.");
            return;
        }

        if (ingresso.utilizar()) {
            System.out.println("Ingresso utilizado com sucesso.");
        } else {
            System.out.println("Ingresso já foi utilizado.");
        }
    }

    public void listarIngressos() {
        for (Ingresso i : ingressos) {
            System.out.println(i);
        }
    }
}


