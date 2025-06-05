package sistema_eventos;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean vip;
    private boolean utilizado;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
        this.utilizado = false;
    }

    public boolean utilizar() {
        if (!utilizado) {
            utilizado = true;
            return true;
        }
        return false;
    }

    public double getValor() {
        return evento.calcularValorIngresso(vip);
    }

    public Evento getEvento() {
        return evento;
    }

    public boolean isVip() {
        return vip;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Ingresso para " + evento.getNome() + " | Cliente: " + cliente.getNome() +
               " | VIP: " + vip + " | Valor: R$" + getValor() + " | Utilizado: " + utilizado;
    }
}


