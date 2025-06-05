public abstract class Evento {
    protected String nome;
    protected int dias;
    protected double valorDiario;
    protected int capacidade;
    protected int ingressosVendidos;

    public Evento(String nome, int dias, double valorDiario, int capacidade) {
        this.nome = nome;
        this.dias = dias;
        this.valorDiario = valorDiario;
        this.capacidade = capacidade;
        this.ingressosVendidos = 0;
    }

    public abstract double calcularValorIngresso(boolean isVip);

    public double calcularValorTotalIngresso() {
        return dias * valorDiario;
    }

    public boolean haVagasDisponiveis(boolean isVip) {
        return ingressosVendidos < capacidade;
    }

    public void venderIngresso() {
        if (ingressosVendidos < capacidade) {
            ingressosVendidos++;
        }
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

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }
}
