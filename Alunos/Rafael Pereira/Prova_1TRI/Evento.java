package fag;

import java.util.ArrayList;
import java.util.List;

public abstract class Evento {
    private String nome;
    protected int duracaoDias;
    protected double precoPorDia;
    protected int capacidade;
    private List<Cliente> participantes;

    public Evento(String nome, int duracaoDias, double precoPorDia, int capacidade) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.precoPorDia = precoPorDia;
        this.capacidade = capacidade;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Cliente> getParticipantes() {
        return participantes;
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (participantes.size() < capacidade) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public abstract double calcularValorIngresso(boolean vip);
}
