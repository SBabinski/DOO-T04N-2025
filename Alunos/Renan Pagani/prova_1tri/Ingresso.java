package prova;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean vip;
    private boolean utilizado = false;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
    }

    public void utilizarIngresso() {
        if (!utilizado) {
            utilizado = true;
            System.out.println("Ingresso utilizado por " + cliente.getNome());
        } else {
            System.out.println("Ingresso já foi utilizado.");
        }
    }

    public double getValor() {
        return evento.calcularValorIngresso(vip);
    }

    public boolean isVip() {
        return vip;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }
}