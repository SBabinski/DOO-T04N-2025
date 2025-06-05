package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Evento {
    protected String nome;
    protected Date dataInicio;
    protected Date dataFim;
    protected double valorDiario;
    protected int capacidade;
    protected List<Cliente> participantes;

    public Evento(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidade) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
        this.participantes = new ArrayList<>();
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (participantes.size() < capacidade) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public int getNumeroParticipantes() {
        return participantes.size();
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getDuracaoDias() {
        long diferenca = dataFim.getTime() - dataInicio.getTime();
        return (int) ((diferenca / (1000 * 60 * 60 * 24)) + 1);
    }

    public abstract double calcularValorIngresso(boolean vip);

    public String getNome() {
        return nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return nome + " | De: " + sdf.format(dataInicio) + " até " + sdf.format(dataFim) +
               " | Valor diário: R$" + valorDiario + " | Capacidade: " + capacidade + 
               " | Participantes: " + participantes.size();
    }
}
