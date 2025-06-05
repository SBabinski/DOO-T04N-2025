public class Ingresso {
    private Cliente cliente;
    private Evento evento;
    private boolean utilizado;

    public Ingresso(Cliente cliente, Evento evento) {
        this.cliente = cliente;
        this.evento = evento;
        this.utilizado = false;
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

    public void utilizar() {
        if (!utilizado) {
            utilizado = true;
            System.out.println("Ingresso utilizado com sucesso!");
        } else {
            System.out.println("Ingresso já foi utilizado.");
        }
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "Cliente='" + cliente.getNome() + '\'' +
                ", Evento='" + evento.getNome() + '\'' +
                ", Utilizado=" + utilizado +
                '}';
    }
}
