public class EventoCongresso extends Evento {

    public EventoCongresso(String nome, String dataInicio, String dataFim, double valorDiario, int numeroMaximoClientes) {
        super(nome, dataInicio, dataFim, valorDiario, numeroMaximoClientes);
    }

    @Override
    public double calcularValorIngresso(int dias, boolean isVIP) {
        if (isVIP) {
            System.out.println("Eventos de congresso não têm área VIP.");
            return -1;
        }
        return valorDiario * dias;  
    }

    @Override
    public String toString() {
        return super.toString() + " | Congresso";
    }
}
