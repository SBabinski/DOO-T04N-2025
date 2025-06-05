package prova;

public class Congresso extends Evento{

    public Congresso(String nome, int dias, double preco, int capacidade) {
        super(nome, dias, preco, capacidade);
    }

    @Override
    public String toString() {
        return "Congresso: " + nome + " (" + dias + " dias, R$" + precoDiaria + "/dia, Capacidade: " + capacidade + ")";
    }
}
