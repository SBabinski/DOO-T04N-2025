package prova;

import java.util.*;

public abstract class Evento {
    protected String nome;
    protected int dias;
    protected double precoDiario;
    protected int capacidadeMax;
    protected List<Cliente> participantes = new ArrayList<>();
    protected List<Ingresso> ingressos = new ArrayList<>();

    public Evento(String nome, int dias, double precoDiario, int capacidadeMax) {
        this.nome = nome;
        this.dias = dias;
        this.precoDiario = precoDiario;
        this.capacidadeMax = capacidadeMax;
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (participantes.size() < capacidadeMax) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public abstract double calcularValorIngresso(boolean vip);

    public String getNome() {
        return nome;
    }

    public int getDias() {
        return dias;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public int getVagasDisponiveis() {
        return capacidadeMax - participantes.size();
    }

    public boolean temVaga() {
        return getVagasDisponiveis() > 0;
    }

    public void registrarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}