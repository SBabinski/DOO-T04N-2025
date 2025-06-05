package prova_1tri;

import java.util.ArrayList;
import java.util.List;

public abstract class Evento {
    private String nome;
    private int capacidade;
    private double valorDiario;
    private int duracaoDias;
    private List<Ingresso> ingressosVendidos;

    public Evento(String nome, int capacidade, double valorDiario, int duracaoDias) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.valorDiario = valorDiario;
        this.duracaoDias = duracaoDias;
        this.ingressosVendidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public int getVagasDisponiveis() {
        return capacidade - ingressosVendidos.size();
    }

    public double calcularValorTotalIngresso() {
        return valorDiario * duracaoDias;
    }

    public boolean verificarDisponibilidade() {
        return getVagasDisponiveis() > 0;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        this.ingressosVendidos.add(ingresso);
    }

    public abstract double calcularValorIngresso(boolean areaVip);

    @Override
    public String toString() {
        return "Nome: " + nome + ", Capacidade: " + capacidade + ", Valor Diário: R$" + String.format("%.2f", valorDiario) + ", Duração: " + duracaoDias + " dias, Vagas Disponíveis: " + getVagasDisponiveis();
    }
}