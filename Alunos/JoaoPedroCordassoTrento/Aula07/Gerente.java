public class Gerente extends Funcionario {
    public Gerente(int idLojaFuncionario, String nome, int idade, Loja loja, Endereco endereco,
                    double salarioBase, double[] salarioRecebido) {
        super(idLojaFuncionario, nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, meu nome é " + getNome() + " tenho " + getIdade() +
         " anos de idade e sou gerente na loja " + getLoja().getNomeFantasia());
    }
    @Override
    public double calcularBonus() {
        double bonus = getSalarioBase();
        bonus = bonus * 0.35;
        return bonus;
    }
}