package sistema_gerenciamento;

public class Show extends Evento {
    private int vagasVIP;
    private double valorVIP;

    public Show(String nome, int dias, double valorDiario, int capacidade, int vagasVIP, double valorVIP) {
        super(nome, dias, valorDiario, capacidade); // Chama o construtor da classe pai (Evento)
        this.vagasVIP = vagasVIP;
        this.valorVIP = valorVIP;
    }

    // Métodos de acesso
    public int getVagasVIP() {
        return vagasVIP;
    }

    public double calcularValorIngressoVIP() {
        return valorVIP;
    }
}