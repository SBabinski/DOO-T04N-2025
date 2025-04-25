import java.util.Date;

public abstract class Funcionario extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private double[] salarioRecebido;

    public Funcionario(String nome, int idade, Endereco endereco, 
                      Loja loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase, salarioBase*1.1, salarioBase*0.9};
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public abstract double calcularBonus();

    public Loja getLoja() {
        return loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
