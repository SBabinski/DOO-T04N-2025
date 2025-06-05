public class Evento {
    private int idEvento;
    private String nomeEvento;
    private int qtdIngressos;
    private double valorIngresso;
    private int qtdIngressosVendidos;
    private int qtdIngressosVIP;
    private double valorIngressoVIP;
    private int qtdIngressosVendidosVIP;
    private int diasDuracao;
    private String tipoEvento;

    public int getIdEvento() {
        return idEvento;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public int getQtdIngressos() {
        return qtdIngressos;
    }
    public double getValorIngresso() {
        return valorIngresso;
    }
    public int getQtdIngressosVendidos() {
        return qtdIngressosVendidos;
    }
    public void setQtdIngressosVendidos(int qtdIngressosVendidos) {
        this.qtdIngressosVendidos = qtdIngressosVendidos;
    }
    public int getQtdIngressosVIP() {
        return qtdIngressosVIP;
    }
    public int getQtdIngressosVendidosVIP() {
        return qtdIngressosVendidosVIP;
    }
    public void setQtdIngressosVendidosVIP(int qtdIngressosVendidosVIP) {
        this.qtdIngressosVendidosVIP = qtdIngressosVendidosVIP;
    }
    public double getValorIngressoVIP() {
        return valorIngressoVIP;
    }
    public int getDiasDuracao() {
        return diasDuracao;
    }
    public String getTipoEvento() {
        return tipoEvento;
    }

    public Evento() {
        super();
    }
    public Evento(int idEvento, String nomeEvento, int qtdIngressos, double valorIngresso, int diasDuracao, String tipoEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.diasDuracao = diasDuracao;
        this.tipoEvento = tipoEvento;
        if(tipoEvento == "show") {
            this.qtdIngressosVIP = (qtdIngressos / 100) * 10;
            this.qtdIngressos = (qtdIngressos / 100) * 90;
            this.valorIngressoVIP = valorIngresso * 1.25;
            this.valorIngresso = valorIngresso;
        } else {
            this.qtdIngressos = qtdIngressos;
            this.valorIngresso = valorIngresso;
            this.valorIngressoVIP = 0;
            this.qtdIngressosVIP = 0;
        }
    }

    @Override
    public String toString() {
        return "Nome evento: " + getNomeEvento()
        + ", quantidade total de ingressos: " + (getQtdIngressos() + getQtdIngressosVIP())
        + ", dias de duração: " + getDiasDuracao()
        + ", tipo do evento: " + getTipoEvento()
        + ", ingressos vendidos: " + (getQtdIngressosVendidos()+getQtdIngressosVendidosVIP());
    }

    public int mostrarIgressosDisponiveis() {
        return getQtdIngressos() - getQtdIngressosVendidos();
    }

    public int mostrarIgressosVIPDisponiveis() {
        return getQtdIngressosVIP() - getQtdIngressosVendidosVIP();
    }

}
