import java.util.ArrayList;

public class Vendedor {
    public String nome;
    public Integer idade;
    public String loja;
    public Endereco endereco;
    public Double salarioBase;
    public ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, Integer idade, String loja, Endereco endereco, Double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2600.0);
        this.salarioRecebido.add(2550.0);
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
        return salarioBase * 0.2;
    }
    
}