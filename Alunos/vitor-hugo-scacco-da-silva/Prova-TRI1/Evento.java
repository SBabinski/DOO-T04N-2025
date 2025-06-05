import java.util.*;

public abstract class Evento {
    protected String nome;
    protected Date dataInicio;
    protected Date dataFim;
    protected double valorDiario;
    protected int capacidade;
    protected List<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, Date dataInicio, Date dataFim, double valorDiario, int capacidade) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
    }

    public long getNumeroDias() {
        long diff = dataFim.getTime() - dataInicio.getTime();
        return (diff / (1000 * 60 * 60 * 24)) + 1;
    }

    public boolean temDisponibilidade() {
        return participantes.size() < capacidade;
    }

    public double calcularValorIngresso(boolean vip) {
        double valor = valorDiario * getNumeroDias();
        if (vip && this instanceof Show) {
            valor *= 1.5;
        }
        return valor;
    }

    public boolean adicionarParticipante(Cliente cliente) {
        if (temDisponibilidade()) {
            participantes.add(cliente);
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }
}
