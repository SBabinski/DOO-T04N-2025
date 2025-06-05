public class Congresso extends Evento {
    public Congresso(String nome, int duracaoDias, double valorIngressoDiario, int capacidadeMaxima) {
        super(nome, duracaoDias, valorIngressoDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean areaVip) {
        return calcularValorTotalIngresso(); 
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Congresso");
    }
}