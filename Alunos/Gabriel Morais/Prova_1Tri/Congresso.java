package entities;

public class Congresso extends Evento {
    public Congresso(String nome, int dias, double precoDiario, int capacidade) {
        super(nome, dias, precoDiario, capacidade);
    }
    
    @Override
    public double calcularValor(boolean vip) {
        return getPrecoDiario() * getDias();
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Congresso)";
    }
}