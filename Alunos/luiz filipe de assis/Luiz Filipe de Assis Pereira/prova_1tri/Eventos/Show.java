
class Show extends Evento {
    private int capacidadeVIP;
    private int vipUsados = 0;

    public Show(String nome, int dias, double valorDiario, int capacidade) {
        super(nome, dias, valorDiario, capacidade);
        this.capacidadeVIP = (int)(capacidade * 0.1);
    }

    public boolean verificarDisponibilidadeVIP() {
        return vipUsados < capacidadeVIP;
    }

    public void usarVIP() {
        vipUsados++;
    }

    public String getTipo() {
        return "Show";
    }
}



