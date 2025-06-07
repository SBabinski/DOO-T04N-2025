public class EventoCongresso extends Evento {
    public EventoCongresso(int id, String nome, java.time.LocalDate dataInicio, java.time.LocalDate dataFim, int maxClientes, double valorIngressoDiario) {
        super(id, nome, dataInicio, dataFim, maxClientes, valorIngressoDiario);
    }
    
    @Override
    public double calcularValorIngresso(String tipo) {
   
        return getValorIngressoDiario() * getDuracao();
    }
    
    @Override
    public String toString() {
        return "EventoCongresso " + super.toString();
    }
}

