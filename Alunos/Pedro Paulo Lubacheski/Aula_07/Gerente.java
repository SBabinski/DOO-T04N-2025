
import java.util.Arrays;

public class Gerente {

    private String nome;
    private Integer idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private Double[] salarioRecebido = {5000.0, 5200.0, 5100.0};

    public Gerente(String nome, Integer idade, String loja, String cidade, String bairro, String rua, Double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return Arrays.stream(salarioRecebido).mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
