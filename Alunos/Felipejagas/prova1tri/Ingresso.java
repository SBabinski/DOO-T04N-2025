public class Ingresso {
    private Cliente cliente;
    private Evento evento;

    public Ingresso(Cliente cliente, Evento evento) {
        this.cliente = cliente;
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Evento: " + evento.getNome();
    }
}