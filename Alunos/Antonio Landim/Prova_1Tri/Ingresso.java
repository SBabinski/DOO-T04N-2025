package entities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private Date dataCompra;
    private boolean vip;
    private boolean utilizado;

    public Ingresso(Cliente cliente, Evento evento, boolean vip, Date dataCompra) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
        this.dataCompra = dataCompra;
        this.utilizado = false;
    }

    public void usarIngresso() {
        if (!utilizado) {
            utilizado = true;
        }
        
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public double calcularValor() {
        return evento.calcularValorIngresso(vip);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Ingresso para " + evento.getNome() + ", Cliente: " + cliente.getNome()
            + ", VIP: " + (vip ? "Sim" : "Não") + ", Usado: " + (utilizado ? "Sim" : "Não") + ", Data da Compra: " + sdf.format(dataCompra);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public boolean isVip() {
        return vip;
    }
}
