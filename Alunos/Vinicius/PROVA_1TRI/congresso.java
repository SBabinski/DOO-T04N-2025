public class congresso extends evento {
    public congresso(String nome, int duracao, Double preco, int capacidade) {
        super(nome, duracao, preco, capacidade);
    }

    @Override
    public double calcularPreco(boolean vip) {
        return duracao * preco;
        }
    }
