import java.util.ArrayList;

public class Gerente {
    public String nome;
    public Integer idade;
    public String loja;
    public Endereco endereco;
    public Double salarioBase;
    public ArrayList<Double> salarioRecebido;

    public Gerente(Endereco endereco, Integer idade, String loja, String nome, Double salarioBase, ArrayList<Double> salarioRecebido) {
        this.endereco = endereco;
        this.idade = idade;
        this.loja = loja;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();

        this.salarioRecebido.add(4500.0);
        this.salarioRecebido.add(3900.0);    
        this.salarioRecebido.add(4550.0);
    }

    

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }

}
