package eventos;

public class Ingresso {
    private Cliente cliente;
    private boolean vip;
    private boolean usado = false;

    public Ingresso(Evento evento, Cliente cliente, boolean vip) {
        this.cliente = cliente;
        this.vip = vip;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isVip() {
        return vip;
    }

    public void usar() {
        if (!usado) {
            usado = true;
            System.out.println("Ingresso usado com sucesso!");
        } else {
            System.out.println("Este ingresso já foi usado.");
        }
    }
}
