package fag;

public class Congresso extends Evento {

    public Congresso(String nome, int duracaoDias, double precoPorDia, int capacidade) {
        super(nome, duracaoDias, precoPorDia, capacidade);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        // Congresso não tem VIP, ignora o 'vip' :)
        return getDuracaoDias() * getPrecoPorDia();
    }
}
