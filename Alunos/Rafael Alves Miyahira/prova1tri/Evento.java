package prova1tri;

import java.util.ArrayList;

public abstract class Evento {
    protected String nome;
    protected String dataInicio;
    protected String dataFim;
    protected double valorDiaria;
    protected int vagasMaximas;
    protected ArrayList<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, String dataInicio, String dataFim, double valorDiaria, int vagasMaximas) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiaria = valorDiaria;
        this.vagasMaximas = vagasMaximas;
    }

    public boolean verificarDisponibilidade() {
        return participantes.size() < vagasMaximas;
    }

    public void adicionarParticipante(Cliente cliente) {
        if (verificarDisponibilidade()) {
            participantes.add(cliente);
        } else {
            System.out.println("Não há vagas disponíveis para este evento.");
        }
    }

    public double calcularValorIngresso(int dias) {
        return dias * valorDiaria;
    }

    public abstract void exibirDetalhes();
}
