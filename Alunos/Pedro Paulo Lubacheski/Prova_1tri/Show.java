
import java.util.ArrayList;
import java.util.List;

public class Show {

    private String nome;
    private int duracaoDias;
    private double valorDiario;
    private double valorAdicionalVip;
    private int capacidade;
    private List<Ingresso> ingressos;

    public Show(String nome, int duracaoDias, double valorDiario,
            double valorAdicionalVip, int capacidade) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.valorDiario = valorDiario;
        this.valorAdicionalVip = valorAdicionalVip;
        this.capacidade = capacidade;
        this.ingressos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double calcularValor(boolean vip) {
        return vip ? (valorDiario + valorAdicionalVip) * duracaoDias
                : valorDiario * duracaoDias;
    }

    public boolean venderIngresso(Cliente cliente, boolean vip) {
        if (ingressos.size() < capacidade) {
            ingressos.add(new Ingresso(cliente, vip));
            return true;
        }
        return false;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public int getVagasDisponiveis() {
        return capacidade - ingressos.size();
    }

    @Override
    public String toString() {
        return "Show: " + nome
                + "\nDuração: " + duracaoDias + " dias"
                + "\nValor diário normal: R$" + valorDiario
                + "\nValor diário adicional VIP: R$" + valorAdicionalVip
                + "\nCapacidade total: " + capacidade;
    }
}
