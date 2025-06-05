public abstract class Evento {
    protected String nome;
    protected String dataInicio;
    protected String dataFim;
    protected double valorDiario;
    protected int numeroMaximoClientes;
    protected int numeroClientes;
    protected int vagasVIP;

    public Evento(String nome, String dataInicio, String dataFim, double valorDiario, int numeroMaximoClientes) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
        this.numeroMaximoClientes = numeroMaximoClientes;
        this.numeroClientes = 0;
        this.vagasVIP = (int) (numeroMaximoClientes * 0.1);  
    }

    public abstract double calcularValorIngresso(int dias, boolean isVIP);

    public boolean adicionarParticipante() {
        if (numeroClientes < numeroMaximoClientes) {
            numeroClientes++;
            return true;
        }
        return false;
    }

    public boolean temVagasVIP() {
        return vagasVIP > 0;
    }

    public String toString() {
        return nome + " | Início: " + dataInicio + " | Fim: " + dataFim + " | Vagas restantes: " + (numeroMaximoClientes - numeroClientes);
    }
}
