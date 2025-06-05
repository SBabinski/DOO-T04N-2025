package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Evento {
    protected String nome;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected double valorDiaria;
    protected int capacidadeMaxima;
    protected List<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, LocalDate dataInicio, LocalDate dataFim, double valorDiaria, int capacidadeMaxima) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiaria = valorDiaria;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public abstract double calcularValorIngresso(boolean vip);

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

    public int getDuracaoDias() {
        return (int) (dataFim.toEpochDay() - dataInicio.toEpochDay()) + 1;
    }

    public String getNome() {
        return nome;
    }
}
