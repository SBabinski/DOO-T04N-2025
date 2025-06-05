package prova1tri;

public class Ingresso {
    private Evento evento;
    private Cliente cliente;
    private int dias;
    private double valor;

    public Ingresso(Evento evento, Cliente cliente, int dias) {
        this.evento = evento;
        this.cliente = cliente;
        this.dias = dias;
        this.valor = evento.calcularValorIngresso(dias);
    }

    public double getValor() {
        return valor;
    }

    public String getClienteNome() {
        return cliente.getNome();
    }

    public String getEventoNome() {
        return evento.nome;
    }
}
