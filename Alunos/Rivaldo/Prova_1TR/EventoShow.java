public class EventoShow extends Evento {

    public EventoShow(String nome, String dataInicio, String dataFim, double valorDiario, int numeroMaximoClientes) {
        super(nome, dataInicio, dataFim, valorDiario, numeroMaximoClientes);
    }

    @Override
    public double calcularValorIngresso(int dias, boolean isVIP) {
        double valor = valorDiario * dias;
        if (isVIP && temVagasVIP()) {
            vagasVIP--;
            valor *= 1.2;
        }
        return valor;
    }

    @Override
    public String toString() {
        return super.toString() + " | Show com área VIP";
    }
}
