// Ingresso.java
public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean vip;
    private boolean usado = false;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
    }

    public void usar() {
        if (!usado) {
            usado = true;
            System.out.println("Ingresso utilizado com sucesso.");
        } else {
            System.out.println("Ingresso já foi usado.");
        }
    }

    public String toString() {
        return cliente + " - Evento: " + evento.nome + " - VIP: " + vip + " - Usado: " + usado;
    }
}
