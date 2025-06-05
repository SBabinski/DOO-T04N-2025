package eventos;

import java.time.LocalDate;

public class Show extends Evento {
    public Show(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
    }

    @Override
    public boolean temVagaVip() {
        long vipUsados = ingressos.stream().filter(Ingresso::isVip).count();
        return vipUsados < capacidade * 0.1;
    }

    @Override
    public double getMultiplicadorVip() {
        return 1.00;
    }

    @Override
    public String getTipo() {
        return "Show";
    }
}


