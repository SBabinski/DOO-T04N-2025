package classes;

public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean vip;
    private double valorPago;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
        this.valorPago = evento.calcularValorIngresso(vip);
    }

    public void apresentarIngresso() {
        System.out.println("\nDetalhes do ingresso:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Evento: " + evento.getNome());
        System.out.println("VIP: " + (vip ? "Sim" : "Não"));
        System.out.println("Valor pago: R$ " + valorPago);
    }
}
