package prova;

public class Congresso extends Evento {
    public Congresso(String nome, int dias, double precoDiario, int capacidadeMax) {
        super(nome, dias, precoDiario, capacidadeMax);
    }

    @Override
    public double calcularValorIngresso(boolean vip) { 
        return precoDiario * dias;
    }
}