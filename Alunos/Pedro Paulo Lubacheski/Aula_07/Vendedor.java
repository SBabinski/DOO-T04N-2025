
public class Vendedor {

    private String nome;
    private Integer idade;
    private String loja;
    private Endereco endereco;
    private Double salarioBase;
    private Double[] salarioRecebido = {3000.0, 3200.0, 3100.0};

    public Vendedor(String nome, Integer idade, String loja, Endereco endereco, Double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        endereco.apresentarLogradouro();
    }

    public double calcularMedia() {
        double soma = 0;
        for (double s : salarioRecebido) {
            soma += s;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }
}
