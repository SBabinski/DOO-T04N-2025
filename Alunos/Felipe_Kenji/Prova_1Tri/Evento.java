public class Evento {
    private String nome;
    private int dias;
    private double valorDiario;
    private int vagas;
    private int vagasVIP;
    private int ingressosVIPVendidos;
    private int ingressosNormaisVendidos;

    public Evento(String nome, int dias, double valorDiario, int vagas) {
        this.nome = nome;
        this.dias = dias;
        this.valorDiario = valorDiario;
        this.vagas = vagas;
        this.vagasVIP = (int) (vagas * 0.1);
        this.ingressosVIPVendidos = 0;
        this.ingressosNormaisVendidos = 0;
    }

    public double calcularValorIngresso() {
        return valorDiario * dias;
    }

    public boolean comprarIngressoVIP() {
        if (ingressosVIPVendidos < vagasVIP) {
            ingressosVIPVendidos++;
            return true;
        }
        return false;
    }

    public boolean comprarIngressoNormal() {
        if (ingressosNormaisVendidos < (vagas - vagasVIP)) {
            ingressosNormaisVendidos++;
            return true;
        }
        return false;
    }
    public boolean adicionarParticipante(Cliente cliente) {
        return comprarIngressoNormal();
    }    

    public boolean utilizarIngresso() {
        if (ingressosVIPVendidos + ingressosNormaisVendidos > 0) {
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVagasVIP() {
        return vagasVIP;
    }

    public int getIngressosVIPVendidos() {
        return ingressosVIPVendidos;
    }

    public int getIngressosNormaisVendidos() {
        return ingressosNormaisVendidos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Dias: " + dias + " | Vagas: " + vagas + " | VIP: " + vagasVIP + " | Ingressos Vendidos VIP: " + ingressosVIPVendidos + " | Ingressos Vendidos Normais: " + ingressosNormaisVendidos;
    }
}
