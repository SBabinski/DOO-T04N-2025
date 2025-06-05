package prova1tri;

public class Congresso extends Evento {
    public Congresso(String nome, String dataInicio, String dataFim, double valorDiaria, int vagasMaximas) {
        super(nome, dataInicio, dataFim, valorDiaria, vagasMaximas);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Evento: " + nome);
        System.out.println("Tipo: Congresso");
        System.out.println("Data Início: " + dataInicio);
        System.out.println("Data Fim: " + dataFim);
        System.out.println("Valor Diária: R$ " + valorDiaria);
        System.out.println("Vagas Máximas: " + vagasMaximas);
    }
}
