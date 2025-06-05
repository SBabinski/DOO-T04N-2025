package evento;

public abstract class Evento {
    protected String nome;
    protected int dias;
    protected double valorDiario;
    protected int capacidadeMaxima;
    protected int participantes;

    public Evento(String nome, int dias, double valorDiario, int capacidadeMaxima) {
        this.nome = nome;
        this.dias = dias;
        this.valorDiario = valorDiario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = 0;
    }

    public boolean podeParticipar() {
        return participantes < capacidadeMaxima;
    }

    public void adicionarParticipante() {
        if (podeParticipar()) {
            participantes++;
        }
    }

    public abstract double calcularValorIngresso(boolean vip);

    public String getNome() { return nome; }
    public int getDias() { return dias; }
    public double getValorDiario() { return valorDiario; }
    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public int getParticipantes() { return participantes; }
}
