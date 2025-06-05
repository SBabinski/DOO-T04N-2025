package prova_1tri;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean utilizado;
    private boolean areaVip;

    public Ingresso(Cliente cliente, Evento evento, boolean areaVip) {
        this.cliente = cliente;
        this.evento = evento;
        this.utilizado = false;
        this.areaVip = areaVip;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public boolean isAreaVip() {
        return areaVip;
    }

    public void marcarUtilizado() {
        this.utilizado = true;
    }

    @Override
    public String toString() {
        String tipoIngresso = areaVip ? "VIP" : "Normal";
        return "Ingresso " + tipoIngresso + " - Cliente: " + cliente.getNome() + ", Evento: " + evento.getNome();
    }
}