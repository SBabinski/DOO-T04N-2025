public class Show extends Evento {
    private static final double PORCENTAGEM_VIP = 0.10; 

    public Show(String nome, int vagasTotais, double valorDiario) {
        super(nome, vagasTotais, valorDiario);
    }

    @Override
    public double calcularValorIngresso(int dias) {
        double valor = getValorDiario() * dias;
        int vagasVIP = (int) (getVagasTotais() * PORCENTAGEM_VIP);

        if (dias > 1 && vagasVIP > 0) {
            valor *= 1.2; 
        }
        return valor;
    }
}
