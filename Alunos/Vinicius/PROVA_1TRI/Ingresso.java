public class Ingresso {
    private cliente cliente;
    private evento evento;
    private boolean usado = false;
    private boolean vip;

    public Ingresso(cliente cliente, evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
    }
    
    public boolean isVip() {
        return vip;
    }

    public boolean usar() {
        if (!usado) {
            usado = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Ingresso - Cliente: " + cliente.getNome() + ", Evento: " + evento.getNome() + ", VIP: " + vip + ", Usado: " + usado;
    }

}
