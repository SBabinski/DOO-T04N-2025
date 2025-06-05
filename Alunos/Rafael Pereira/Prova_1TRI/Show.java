package fag;

public class Show extends Evento {
    private double adicionalVip;

    public Show(String nome, int duracaoDias, double precoPorDia, int capacidade, double adicionalVip) {
        super(nome, duracaoDias, precoPorDia, capacidade);
        this.adicionalVip = adicionalVip;
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        double valor = getDuracaoDias() * getPrecoPorDia();
        if (vip) {
            valor += valor * adicionalVip;
        }
        return valor;
    }

    public int getVagasVipDisponiveis() {
        long ocupadas = getParticipantes().stream()
                             .filter(p -> p instanceof ClienteVip)
                             .count();
        return (int)(getCapacidade() * 0.1 - ocupadas);
    }
}
