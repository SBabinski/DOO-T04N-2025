
public class Ingresso {

    private Cliente cliente;
    private boolean vip;
    private boolean utilizado;

    public Ingresso(Cliente cliente, boolean vip) {
        this.cliente = cliente;
        this.vip = vip;
        this.utilizado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isVip() {
        return vip;
    }

    public void utilizar() {
        utilizado = true;
    }

    public boolean isUtilizado() {
        return utilizado;
    }
}
