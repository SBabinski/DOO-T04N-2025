package entities;

import java.util.Date;

public class Show extends Evento {
    private static final double TAXA_VIP = 1.5;

    public Show(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidade) {
        super(nome, dataInicio, dataFim, valorDiario, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        double valorBase = valorDiario * getDuracaoDias();
        return vip ? valorBase * TAXA_VIP : valorBase;
    }

    public int getVagasVip() {
        return (int)(capacidade * 0.1);
    }

    public int getVagasComuns() {
        return capacidade - getVagasVip();
    }
}
