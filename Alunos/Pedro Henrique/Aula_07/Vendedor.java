package gerenciamento_empresa;
public class Vendedor extends Funcionario {
    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.15;
    }
}