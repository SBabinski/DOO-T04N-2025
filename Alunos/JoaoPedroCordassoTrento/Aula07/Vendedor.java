public class Vendedor extends Funcionario {
    public Vendedor(int idLojaFuncionario, String nome, int idade, Loja loja, Endereco endereco,
                    double salarioBase, double[] salarioRecebido) {
        super(idLojaFuncionario, nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, meu nome é " + getNome() + " tenho " + getIdade() +
         " anos de idade e sou vendedor na loja " + getLoja().getNomeFantasia());
    }
    @Override
    public double calcularBonus() {
        double bonus = getSalarioBase();
        bonus = bonus * 0.2;
        return bonus;
    }
}