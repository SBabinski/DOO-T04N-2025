public class Evento {
    private String nome;
    private int duracaoDias;
    private double valorDiario;
    private int capacidadeMaxima;
    private String tipo;
    private int vagasVip;

    public Evento(String nome, int duracaoDias, double valorDiario, int capacidadeMaxima, String tipo) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.valorDiario = valorDiario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.tipo = tipo;

        if (tipo.equalsIgnoreCase("show")) {
            this.vagasVip = (int) (capacidadeMaxima * 0.1);
        } else {
            this.vagasVip = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", duração=" + duracaoDias + " dias" +
                ", valor diário=R$" + valorDiario +
                ", capacidade máxima=" + capacidadeMaxima +
                ", tipo='" + tipo + '\'' +
                ", vagas VIP=" + vagasVip +
                '}';
    }
}
