package prova1tri;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Evento {
    protected String nome;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected double precoDiario;
    protected int capacidade;
    protected ArrayList<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, LocalDate dataInicio, LocalDate dataFim, double precoDiario, int capacidade) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.precoDiario = precoDiario;
        this.capacidade = capacidade;
    }

    public long getDuracao() {
        return ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
    }

    public boolean temVagas() {
        return participantes.size() < capacidade;
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (temVagas()) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularValorIngresso();
}
