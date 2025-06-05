public class Show extends Evento {
    public Show(String nome, int duracaoDias, double valorIngressoDiario, int capacidadeMaxima) {
        super(nome, duracaoDias, valorIngressoDiario, capacidadeMaxima);
    }

    @Override
    public double calcularValorIngresso(boolean areaVip) {
        double valorBase = calcularValorTotalIngresso();
        if (areaVip) {
            return valorBase * 1.3; // Área VIP 30% mais cara (exemplo)
        }
        return valorBase;
    }

    public int getTotalVagasVIP() {
        return (int) (getCapacidadeMaxima() * 0.1);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Show");
        System.out.println("Vagas VIP: " + getTotalVagasVIP());
    }
}