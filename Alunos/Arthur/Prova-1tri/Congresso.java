public class Congresso extends Evento {
    public Congresso(String nome, int dias, double valorDiario, int capacidade) {
        super(nome, dias, valorDiario, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean isVip) {
        return calcularValorTotalIngresso();
    }
}
