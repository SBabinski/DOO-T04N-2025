package lucas.PROVA_1TRI;

import java.time.LocalDate;

public class Show extends Evento {
    private final int vipCapacidade;
    private static final double VIP_MULTIPLIER = 1.5;

    public Show(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
        this.vipCapacidade = (int) Math.ceil(capacidade * 0.1);
    }

    @Override
    public Ingresso comprarIngresso(Cliente cliente, boolean vip) {
        long dias = getDuracaoDias();
        double precoBase = precoDiario * dias;
        double valor = vip ? precoBase * VIP_MULTIPLIER : precoBase;

        long vendidosVip = ingressos.stream().filter(Ingresso::isVip).count();

        if (vip) {
            if (vendidosVip >= vipCapacidade) {
                System.out.println("Sem ingressos VIP disponíveis.");
                return null;
            }
        } else {
            if (getDisponiveis() - (vipCapacidade - vendidosVip) <= 0) {
                System.out.println("Sem ingressos comuns disponíveis.");
                return null;
            }
        }

        Ingresso ing = new Ingresso(cliente, this, vip, valor);
        ingressos.add(ing);
        return ing;
    }
}


