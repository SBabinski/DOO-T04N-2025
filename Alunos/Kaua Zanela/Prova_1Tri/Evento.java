package classes;

import java.util.Date;

public abstract class Evento {
    protected String nome;
    protected Date dataInicio;
    protected Date dataFim;
    protected double valorDiario;
    protected int capacidadeMaxima;
    protected int participantesAtuais;

    public Evento(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidadeMaxima) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantesAtuais = 0;
    }

    public abstract double calcularValorIngresso(boolean vip);

    public int getDiasEvento() {
        long diff = dataFim.getTime() - dataInicio.getTime();
        return (int) ((diff / (1000 * 60 * 60 * 24)) + 1);
    }

    public boolean verificarDisponibilidade() {
        return participantesAtuais < capacidadeMaxima;
    }

    public boolean adicionarParticipante() {
        if (verificarDisponibilidade()) {
            participantesAtuais++;
            return true;
        }
        return false;
    }

    public void reservarVaga(boolean vip) {
        participantesAtuais++;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getParticipantesAtuais() {
        return participantesAtuais;
    }
}
