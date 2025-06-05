package eventos;
import java.time.LocalDate;




// Show.java
public class Show extends Evento {
    public Show(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
        super(nome, inicio, fim, precoDiario, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        double valorBase = precoDiario * getDuracaoDias();
        return vip ? valorBase * 1.5 : valorBase;
    }

    public int getCapacidadeVip() {
        return (int)(capacidade * 0.1);
    }
}
