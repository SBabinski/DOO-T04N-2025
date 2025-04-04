


class Venda {

    private double preco;
    private int quantidade;
    private char desconto;

    public Venda(double preco, int quantidade, char desconto) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public char getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return "Preço: " + preco + ", Quantidade: " + quantidade + ", Desconto: " + desconto + "%";
    }
}
