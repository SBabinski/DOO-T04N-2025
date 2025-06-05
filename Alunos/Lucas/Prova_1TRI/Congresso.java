package lucas.PROVA_1TRI;

import java.time.LocalDate;

public class Congresso extends Evento {
    public Congresso(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
    }

    @Override
    public Ingresso comprarIngresso(Cliente cliente, boolean vip) {
        if (vip) {
            System.out.println("Congressos não possuem área VIP.");
            return null;
        }
        long dias = getDuracaoDias();
        double valor = precoDiario * dias;

        if (ingressos.size() >= capacidade) {
            System.out.println("Sem ingressos disponíveis.");
            return null;
        }

        Ingresso ing = new Ingresso(cliente, this, false, valor);
        ingressos.add(ing);
        return ing;
    }
}


