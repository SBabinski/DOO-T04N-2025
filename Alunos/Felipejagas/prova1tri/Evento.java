public abstract class Evento {
    String nome;
    int duracaoDias;
    double valorIngressoDiario;
    int capacidadeMaxima;
    int participantesAtuais;

    public Evento(String nome, int duracaoDias, double valorIngressoDiario, int capacidadeMaxima) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
        this.valorIngressoDiario = valorIngressoDiario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantesAtuais = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public double getValorIngressoDiario() {
        return valorIngressoDiario;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getParticipantesAtuais() {
        return participantesAtuais;
    }

    public double calcularValorTotalIngresso() {
        return duracaoDias * valorIngressoDiario;
    }

    public boolean verificarDisponibilidade() {
        return participantesAtuais < capacidadeMaxima;
    }

    public void adicionarParticipante() {
        if (verificarDisponibilidade()) {
            participantesAtuais++;
        }
    }

    public abstract double calcularValorIngresso(boolean areaVip);

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Duração: " + duracaoDias + " dias");
        System.out.println("Valor por dia: R$" + String.format("%.2f", valorIngressoDiario));
        System.out.println("Capacidade: " + capacidadeMaxima + " participantes");
        System.out.println("Participantes atuais: " + participantesAtuais);
    }
}