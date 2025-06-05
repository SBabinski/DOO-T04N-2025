package eventos;
import java.time.LocalDate;

import java.util.ArrayList;

public abstract class Evento {
    protected String nome;
    protected LocalDate inicio, fim;
    protected double precoDiario;
    protected int capacidade;
    protected ArrayList<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.precoDiario = precoDiario;
        this.capacidade = capacidade;
    }

    public long getDuracaoDias() {
        return java.time.temporal.ChronoUnit.DAYS.between(inicio, fim) + 1;
    }

    public boolean temVaga() {
        return participantes.size() < capacidade;
    }

    public boolean adicionarParticipante(Cliente c) {
        if (temVaga()) {
            participantes.add(c);
            return true;
        }
        return false;
    }

    public abstract double calcularValorIngresso(boolean vip);
}
