public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private int dias; 
    private boolean isVIP;
    private double valor;

    public Ingresso(Cliente cliente, Evento evento, int dias, boolean isVIP, double valor) {
        this.cliente = cliente;
        this.evento = evento;
        this.dias = dias;
        this.isVIP = isVIP;
        this.valor = valor;
    }

    public Evento getEvento() {
        return evento;
    }

    public int getDias() {
        return dias;
    }

    public void diminuirDia() {
        if (dias > 0) {
            dias--;
        }
    }

    @Override
    public String toString() {
        return "Ingresso para " + evento + " | Dias restantes: " + dias + " | VIP: " + isVIP + " | Valor: R$ " + valor;
    }
}
