import java.util.*;

public class Show extends Evento {
    private int vagasVIP;
    private List<Cliente> participantesVIP = new ArrayList<>();

    public Show(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidade) {
        super(nome, dataInicio, dataFim, valorDiario, capacidade);
        this.vagasVIP = (int)(capacidade * 0.1);
    }

    public boolean adicionarParticipante(Cliente cliente, boolean vip) {
        if (vip) {
            if (participantesVIP.size() < vagasVIP) {
                participantesVIP.add(cliente);
                return super.adicionarParticipante(cliente);
            }
            return false;
        } else {
            return super.adicionarParticipante(cliente);
        }
    }
}
