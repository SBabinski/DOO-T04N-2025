
import java.util.*;

abstract class Evento {
    protected String nome;
    protected int dias;
    protected double valorDiario;
    protected int capacidade;
    protected List<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, int dias, double valorDiario, int capacidade) {
        this.nome = nome;
        this.dias = dias;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public int getDias() {
        return dias;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean verificarDisponibilidade() {
        return participantes.size() < capacidade;
    }

    public void adicionarParticipante(Cliente cliente) {
        participantes.add(cliente);
    }

    public abstract String getTipo();
}



