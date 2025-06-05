
class Ingresso {
    Cliente cliente;
    Evento evento;
    boolean vip;
    boolean usado = false;

    public Ingresso(Cliente cliente, Evento evento, boolean vip) {
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;

        evento.adicionarParticipante(cliente);
        if (vip && evento instanceof Show show) {
            show.usarVIP();
        }
    }

    public double getValor() {
        double base = evento.getValorDiario() * evento.getDias();
        if (vip && evento instanceof Show) {
            return base * 1.5;
        }
        return base;
    }

    public void usarIngresso() {
        if (!usado) {
            usado = true;
            System.out.println("Ingresso utilizado com sucesso.");
        } else {
            System.out.println("Ingresso já foi utilizado.");
        }
    }
}

