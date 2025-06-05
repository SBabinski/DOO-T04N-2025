public class Congresso extends Evento {
    public Congresso(String nome, int vagasTotais, double valorDiario) {
        super(nome, vagasTotais, valorDiario);
    }

    @Override
    public double calcularValorIngresso(int dias) {
        return getValorDiario() * dias;
    }
}
