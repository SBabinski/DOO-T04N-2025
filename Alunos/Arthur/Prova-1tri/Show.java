public class Show extends Evento {
    private int capacidadeVip;
    private int ingressosVipVendidos;

    public Show(String nome, int dias, double valorDiario, int capacidade) {
        super(nome, dias, valorDiario, capacidade);
        this.capacidadeVip = (int) (capacidade * 0.1);
        this.ingressosVipVendidos = 0;
    }

    @Override
    public double calcularValorIngresso(boolean isVip) {
        double valorTotal = calcularValorTotalIngresso();
        if (isVip) {
            valorTotal *= 1.5;
        }
        return valorTotal;
    }

    public boolean haVagasVipDisponiveis() {
        return ingressosVipVendidos < capacidadeVip;
    }

    public void venderIngressoVip() {
        if (haVagasVipDisponiveis()) {
            ingressosVipVendidos++;
        }
    }

    public int getCapacidadeVip() {
        return capacidadeVip;
    }
}
