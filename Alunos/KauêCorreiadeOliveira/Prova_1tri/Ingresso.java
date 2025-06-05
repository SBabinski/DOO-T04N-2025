public class Ingresso {
    public Cliente cliente;
    public boolean usado = false;
    public boolean vip;

    public Ingresso(Cliente cliente, boolean vip) {
        this.cliente = cliente;
        this.vip = vip;
    }

    public void usar() {
        usado = true;
    }
}

