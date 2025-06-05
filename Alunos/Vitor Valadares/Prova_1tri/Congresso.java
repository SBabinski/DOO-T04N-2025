package prova1tri;

public class Congresso extends Evento {
    public Congresso(String nome, java.time.LocalDate dataInicio, java.time.LocalDate dataFim, double precoDiario, int capacidade) {
        super(nome, dataInicio, dataFim, precoDiario, capacidade);
    }

	@Override
	public double calcularValorIngresso() {
		return 0;
	}
}
