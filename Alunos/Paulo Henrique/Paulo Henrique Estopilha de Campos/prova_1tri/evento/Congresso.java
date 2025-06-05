package evento;

public class Congresso extends Evento {

    public Congresso(String nome, int dias, double valorDiario, int capacidadeMaxima) {
        super(nome, dias, valorDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        return valorDiario * dias;
    }
}
