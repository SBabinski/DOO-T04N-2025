package Aula_07;


public class Gerente extends Pessoa {
    String loja;
    double salarioBase;
    double[] salarioRecebido = {2200, 2300, 2400};

    public Gerente(String nome, int idade, String loja, Endereço endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
