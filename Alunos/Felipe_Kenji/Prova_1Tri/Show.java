public class Show extends Evento {
    private static final double VALOR_VIP_ADICIONAL = 1.2;
    public Show(String nome, int dias, double valorDiario, int vagas) {
        super(nome, dias, valorDiario, vagas);
    }

    @Override
    public double calcularValorIngresso(Cliente cliente) {
        int vagasVip = (int) (getVagas() * 0.10);
        if (getParticipantes().size() < vagasVip) {
            return getValorDiario() * VALOR_VIP_ADICIONAL;
        }
        return getValorDiario();
    }
}
