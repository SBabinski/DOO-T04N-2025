package prova_1tri;

public class Show extends Evento {
    private double valorVipMultiplicador = 1.5; 

    public Show(String nome, int capacidade, double valorDiario, int duracaoDias) {
        super(nome, capacidade, valorDiario, duracaoDias);
    }

    @Override
    public double calcularValorIngresso(boolean areaVip) {
        double valorBase = calcularValorTotalIngresso();
        if (areaVip && getIngressosVendidos().size() < getCapacidade() * 0.1) {
            return valorBase * valorVipMultiplicador;
        }
        return valorBase;
    }

    public int getVagasVipDisponiveis() {
        int vagasVip = (int) (getCapacidade() * 0.1);
        int ingressosVipVendidos = 0;
        for (Ingresso ingresso : getIngressosVendidos()) {
            if (ingresso.isAreaVip()) {
                ingressosVipVendidos++;
            }
        }
        return vagasVip - ingressosVipVendidos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Show, Vagas VIP Disponíveis: " + getVagasVipDisponiveis();
    }
}