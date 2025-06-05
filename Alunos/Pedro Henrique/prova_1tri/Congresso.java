package sistema_gerenciamento;
public class Congresso extends Evento {

    public Congresso(String nome, int dias, double valorDiario, int capacidade) {
        super(nome, dias, valorDiario, capacidade);
    }

    @Override
    public double calcularValorIngresso() {
        // O cálculo do valor do ingresso é igual para todos os congressos
        return super.calcularValorIngresso();
    }
}
