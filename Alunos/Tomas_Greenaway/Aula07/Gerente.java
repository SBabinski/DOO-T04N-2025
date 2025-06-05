import java.util.ArrayList;

public class Gerente {
    String nome;
    int idade;
    String loja;
    double salarioBase;
    ArrayList<Double> salarioRecebido;
    Endereco endereco;

    public Gerente(String nome, int idade, String loja, double salarioBase, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.endereco = endereco;

        salarioRecebido = new ArrayList<>();
        salarioRecebido.add(3000.00);
        salarioRecebido.add(3100.00);
        salarioRecebido.add(3200.00);
    }

    public void apresentarSe() {
        System.out.println("Gerente: " + nome + " | Idade: " + idade + " | Loja: " + loja);
    }

    public double calcularMedia() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
