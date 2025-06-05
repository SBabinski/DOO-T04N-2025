package lucas.PROVA_1TRI;

public class Ingresso {
    private static int counter = 1;
    private final int id;
    private final Cliente cliente;
    private final Evento evento;
    private final boolean vip;
    private final double valor;
    private boolean usado = false;

    public Ingresso(Cliente cliente, Evento evento, boolean vip, double valor) {
        this.id = counter++;
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isUsado() {
        return usado;
    }

    public void usar() {
        if (usado) {
            System.out.println("Ingresso já foi utilizado.");
        } else {
            usado = true;
            System.out.println("Ingresso utilizado com sucesso!");
        }
    }

    @Override
    public String toString() {
        return String.format("Ingresso[%d] Cliente: %s | VIP: %s | Valor: R$%.2f | Usado: %s",
                id, cliente, vip, valor, usado);
    }
}

