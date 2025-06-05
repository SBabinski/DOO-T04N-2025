package eventos;

import java.time.LocalDate;

public class Congresso extends Evento {
    public Congresso(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
    }

    @Override
    public boolean temVagaVip() {
        return false;
    }

    @Override
    public double getMultiplicadorVip() {
        return 1.0;
    }

    @Override
    public String getTipo() {
        return "Congresso";
    }
}
