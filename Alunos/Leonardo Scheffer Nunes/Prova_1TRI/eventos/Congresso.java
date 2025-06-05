package eventos;
import java.time.LocalDate;


// Congresso.java
public class Congresso extends Evento {
    public Congresso(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        return precoDiario * getDuracaoDias(); // congressos não têm VIP
    }
}

