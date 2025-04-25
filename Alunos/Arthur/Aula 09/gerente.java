import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(5000.0);
        this.salarioRecebido.add(5100.0);
        this.salarioRecebido.add(5200.0);
    }

    @Override
    public void apresentarse() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
