package classes;

import java.util.Date;

public class Show extends Evento {
    private static final double VIP_MULTIPLICADOR = 1.5;
    private static final double PORCENTAGEM_VIP = 0.10;
    private int vagasVIP;
    private int participantesVIP;

    public Show(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidadeMaxima) {
        super(nome, dataInicio, dataFim, valorDiario, capacidadeMaxima);
        this.vagasVIP = (int) (capacidadeMaxima * PORCENTAGEM_VIP);
        this.participantesVIP = 0;
    }

    @Override
    public double calcularValorIngresso(boolean vip) {
        int dias = getDiasEvento();
        if (vip) {
            return valorDiario * VIP_MULTIPLICADOR * dias;
        } else {
            return valorDiario * dias;
        }
    }

    public boolean adicionarParticipanteVIP() {
        if (participantesVIP < vagasVIP) {
            participantesVIP++;
            return true;
        }
        return false;
    }

    @Override
    public void reservarVaga(boolean vip) {
        super.reservarVaga(vip);
        if (vip) {
            participantesVIP++;
        }
    }
}
