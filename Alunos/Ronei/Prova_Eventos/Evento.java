// Evento.java
public abstract class Evento {
    protected String nome;
    protected int duracaoDias;
    protected double valorDiario;
    protected int capacidade;
    protected int ingressosVendidos = 0;

    public Evento(String nome, int duracaoDias, double valorDiario, int capacidade) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
    }

    public boolean temVaga() {
        return ingressosVendidos < capacidade;
    }

    public void venderIngresso() {
        ingressosVendidos++;
    }

    public abstract double calcularValor(boolean vip);
    public abstract boolean comprarIngresso(boolean vip);
    public abstract String getTipo();
}
