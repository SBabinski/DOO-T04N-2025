package sistema_gerenciamento;
import java.util.ArrayList;

public class Evento {
    protected String nome;
    protected int dias;
    protected double valorDiario;
    protected int capacidade;
    protected ArrayList<Cliente> participantes = new ArrayList<>();

    public Evento(String nome, int dias, double valorDiario, int capacidade) {
        this.nome = nome;
        this.dias = dias;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
    }

    public boolean comprarIngresso(Cliente cliente) {
        if (participantes.size() < capacidade) {
            participantes.add(cliente);
            return true; 
        } else {
            return false;
        }
    }

    public double calcularValorIngresso() {
        return dias * valorDiario;
    }

    public String getNome() {
        return nome;
    }

    public int getVagasDisponiveis() {
        return capacidade - participantes.size();
    }

    public void mostrarDetalhes() {
        System.out.println("Evento: " + nome);
        System.out.println("Duração: " + dias + " dias");
        System.out.println("Valor do Ingresso: R$ " + calcularValorIngresso());
        System.out.println("Vagas disponíveis: " + getVagasDisponiveis() + "/" + capacidade);
    }
}

