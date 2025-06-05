package prova;

public class Show extends Evento {
    private static final double VIP_MULTIPLICADOR = 1.5;

    public Show(String nome, int dias, double precoDiario, int capacidadeMax) {
        super(nome, dias, precoDiario, capacidadeMax);
    }

    public boolean areaVipDisponivel() {
        int vipMax = (int) (capacidadeMax * 0.1);
        long vipCount = ingressos.stream().filter(Ingresso::isVip).count();
        return vipCount < vipMax;
    }

   
    public double calcularValorIngresso(boolean vip) {
        if (vip) return precoDiario * dias * VIP_MULTIPLICADOR;
        return precoDiario * dias;
    }
}

