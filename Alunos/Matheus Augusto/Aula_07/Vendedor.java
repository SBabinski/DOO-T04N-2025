public class Vendedor extends Funcionario {
    public Vendedor(String nome, int idade, Endereco endereco, 
                   Loja loja, double salarioBase) {
        super(nome, idade, endereco, loja, salarioBase);
    }

    @Override
    public void apresentarse() {
        System.out.println("Meu nome é " + getNome() + ", tenho " + getIdade() + 
                         " anos e trabalho na " + getLoja().getNomeFantasia());
    }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.2;
    }
}
