package evento;

public class Show extends Evento {

    public Show(String nome, int dias, double valorDiario, int capacidadeMaxima) {
        super(nome, dias, valorDiario, capacidadeMaxima);
    }

    public int getCapacidadeVip() {
        return (int) (capacidadeMaxima * 0.1);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        double valor = valorDiario * dias;
        if (vip) {
            valor *= 1.1;
        }
        return valor;
    }
}
