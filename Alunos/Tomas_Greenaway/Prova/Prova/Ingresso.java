public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private int dias;

    public Ingresso(Cliente cliente, Evento evento, int dias) {
        this.cliente = cliente;
        this.evento = evento;
        this.dias = dias;
    }

    public double calcularValor() {
        return evento.calcularValorIngresso(dias);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
