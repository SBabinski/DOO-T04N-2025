public class Congresso extends Evento {

    public Congresso(String nome, int dias, double valorDiario, int vagas) {
        super(nome, dias, valorDiario, vagas);
    }
    public double calcularValorIngresso(Cliente cliente) {
        return getValorDiario();
    }
}
