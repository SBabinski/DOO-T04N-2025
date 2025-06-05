package eventos;

// Ingresso.java
public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean vip;
    private boolean usado;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
        this.usado = false;
    }

    public boolean utilizar() {
        if (!usado) {
            usado = true;
            return true;
        }
        return false;
    }

    public double getValor() {
        return evento.calcularValorIngresso(vip);
    }

    public String toString() {
        return "Ingresso para " + evento.nome + " | Cliente: " + cliente.getNome() + " | VIP: " + vip + " | Valor: R$" + getValor();
    }
}
