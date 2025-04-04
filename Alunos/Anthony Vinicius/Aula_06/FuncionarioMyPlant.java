package sistemamyplant;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionarioMyPlant {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public FuncionarioMyPlant(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        salarioRecebido.add(salarioBase);
        salarioRecebido.add(salarioBase + 200);
        salarioRecebido.add(salarioBase + 300);
    }

    public void apresentarse() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
        System.out.println("Endereço: Rua " + rua + ", Bairro " + bairro + ", Cidade " + cidade);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        double media = salarioRecebido.size() > 0 ? soma / salarioRecebido.size() : 0;
        return arredondar(media);
    }

    public double calcularBonus() {
        return arredondar(salarioBase * 0.2);
    }

    private double arredondar(double valor) {
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getLoja() {
        return loja;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }
}
