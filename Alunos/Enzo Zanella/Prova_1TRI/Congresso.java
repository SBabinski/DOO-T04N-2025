package sistema_eventos;

public class Congresso extends Evento {
    public Congresso(String nome, int duracaoDias, double precoDiario, int capacidadeMaxima) {
        super(nome, duracaoDias, precoDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        return precoDiario * duracaoDias; 
    }
}



