package classes;

import java.util.Date;

public class Congresso extends Evento {

    public Congresso(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidadeMaxima) {
        super(nome, dataInicio, dataFim, valorDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        int dias = getDiasEvento();
        return valorDiario * dias;
    }
}
