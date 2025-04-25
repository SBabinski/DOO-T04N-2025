import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2700.0);
        this.salarioRecebido.add(2800.0);
    }

    @Override
    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public double calcularMedia() {
        double soma = 0.0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
