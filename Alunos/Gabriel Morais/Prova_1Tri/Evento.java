package entities;

import java.util.ArrayList;

public abstract class Evento {
    private String nome;
    private int dias;
    private double precoDiario;
    private int capacidade;
    private ArrayList<Cliente> participantes;
    
    public Evento(String nome, int dias, double precoDiario, int capacidade) {
        this.nome = nome;
        this.dias = dias;
        this.precoDiario = precoDiario;
        this.capacidade = capacidade;
        this.participantes = new ArrayList<>();
    }
    
    public boolean temVagas() {
        return participantes.size() < capacidade;
    }
    
    public boolean addParticipante(Cliente cliente) {
        if (temVagas()) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }
    
    public abstract double calcularValor(boolean vip);
    
    public String getNome() {
        return nome;
    }
    
    public int getDias() {
        return dias;
    }
    
    public double getPrecoDiario() {
        return precoDiario;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    
    public int getVagasDisponiveis() {
        return capacidade - participantes.size();
    }
    
    @Override
    public String toString() {
        return String.format("%s - %d dia(s) - R$%.2f/dia - Capacidade: %d - Vagas: %d",
                            nome, dias, precoDiario, capacidade, getVagasDisponiveis());
    }
}