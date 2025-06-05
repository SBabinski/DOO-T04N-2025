package models;

public class Congresso extends Evento {
    public Congresso(String nome, java.time.LocalDate inicio, java.time.LocalDate fim, double valor, int capacidade) {
        super(nome, inicio, fim, valor, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        return valorDiaria * getDuracaoDias(); 
    }
}
