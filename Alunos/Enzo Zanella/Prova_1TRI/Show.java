package sistema_eventos;

public class Show extends Evento {
    public Show(String nome, int duracaoDias, double precoDiario, int capacidadeMaxima) {
        super(nome, duracaoDias, precoDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        if (vip) {
            return precoDiario * duracaoDias * 1.5; 
        }
        return precoDiario * duracaoDias;
    }
}



