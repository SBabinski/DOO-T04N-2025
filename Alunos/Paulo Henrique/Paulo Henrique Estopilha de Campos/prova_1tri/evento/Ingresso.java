package evento;

public class Ingresso {
    private Evento evento;
    private Cliente cliente;
    private boolean vip;
    private boolean usado;

    public Ingresso(Evento evento, Cliente cliente, boolean vip) {
        this.evento = evento;
        this.cliente = cliente;
        this.vip = vip;
        this.usado = false;
    }

    public double getValor() {
        return evento.calcularValorIngresso(vip);
    }

    public void usar() {
        if (!usado) {
            usado = true;
            System.out.println(cliente.getNome() + " usou ingresso no evento " + evento.getNome());
        } else {
            System.out.println("Ingresso já foi usado.");
        }
    }

    public boolean isUsado() { return usado; }
}
