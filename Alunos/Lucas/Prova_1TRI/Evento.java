package lucas.PROVA_1TRI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// Evento.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Evento {
    private static int counter = 1;
    protected final int id;
    protected String nome;
    protected LocalDate inicio;
    protected LocalDate fim;
    protected double precoDiario;
    protected int capacidade;
    protected List<Ingresso> ingressos = new ArrayList<>();

    public Evento(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        this.id = counter++;
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.precoDiario = precoDiario;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public long getDuracaoDias() {
        return ChronoUnit.DAYS.between(inicio, fim) + 1;
    }

    public int getDisponiveis() {
        return capacidade - ingressos.size();
    }

    public abstract Ingresso comprarIngresso(Cliente cliente, boolean vip);

    @Override
    public String toString() {
        return String.format("%s (%s a %s) – diária R$%.2f – vagas livres: %d",
                nome, inicio, fim, precoDiario, getDisponiveis());
    }
}


