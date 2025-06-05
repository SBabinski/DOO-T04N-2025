package prova;

public class Show extends Evento{

    int vagasVip;
    

    public Show(String nome, int dias, double precoDiaria, int capacidadeMaxima) {
        super(nome, dias, precoDiaria, capacidadeMaxima);
        this.vagasVip = (int)(capacidade * 0.1);
    }

    @Override
    public String toString() {
        return "Show: " + nome + " (" + dias + " dias, R$" + precoDiaria + "/dia, Capacidade: " + capacidade + ")";
    }
}
