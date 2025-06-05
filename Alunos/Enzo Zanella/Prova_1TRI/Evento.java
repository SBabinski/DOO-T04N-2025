package sistema_eventos;

import java.util.ArrayList;

public abstract class Evento {
    protected String nome;
    protected int duracaoDias;
    protected double precoDiario;
    protected int capacidadeMaxima;
    protected ArrayList<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, int duracaoDias, double precoDiario, int capacidadeMaxima) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.precoDiario = precoDiario;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean verificarDisponibilidade() {
        return participantes.size() < capacidadeMaxima;
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (verificarDisponibilidade()) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public abstract double calcularValorIngresso(boolean vip);

    public String getNome() {
        return nome;
    }

    public int getParticipantesAtuais() {
        return participantes.size();
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    @Override
    public String toString() {
        return nome + " - Duração: " + duracaoDias + " dias - R$" + precoDiario + "/dia - Vagas: " + getParticipantesAtuais() + "/" + capacidadeMaxima;
    }
}
