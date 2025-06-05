public class show extends evento {
    private double precoVip = 1.2;
    private int capacidadeVip;

    public show(String nome, int duracao, Double preco, int capacidade) {
        super(nome, duracao, preco, capacidade);
        this.capacidadeVip = (int) (capacidade * 0.1);

    }
    @Override
    public double calcularPreco(boolean vip) {
        if (vip) {
            return duracao * precoVip * preco;
        } else {
            return duracao * preco;
        }
    }

    public long vipTotal() {
        return ingressos.stream().filter(Ingresso::isVip).count();
        }

    @Override
    public boolean registrarIngresso(Ingresso ingresso) {
        if (ingresso.isVip() && vipTotal() >= capacidadeVip) {
            return false;
        } else {
            return super.registrarIngresso(ingresso);
        }
    }
        

}
