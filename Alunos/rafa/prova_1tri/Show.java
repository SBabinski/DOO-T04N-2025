package models;

public class Show extends Evento {
    private double taxaVip;
    private int vagasVip;

    public Show(String nome, java.time.LocalDate inicio, java.time.LocalDate fim, double valor, int capacidade) {
        super(nome, inicio, fim, valor, capacidade);
        this.taxaVip = 1.5; // VIP custa 50% a mais
        this.vagasVip = (int) (capacidade * 0.1);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        double valorBase = valorDiaria * getDuracaoDias();
        return vip ? valorBase * taxaVip : valorBase;
    }
}
