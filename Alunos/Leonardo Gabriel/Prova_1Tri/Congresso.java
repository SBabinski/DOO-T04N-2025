package prova_1tri;

public class Congresso extends Evento {
    public Congresso(String nome, int capacidade, double valorDiario, int duracaoDias) {
        super(nome, capacidade, valorDiario, duracaoDias);
    }

    @Override
    public double calcularValorIngresso(boolean areaVip) {
        return calcularValorTotalIngresso(); // C
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Congresso";
    }
}