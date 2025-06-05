package sistemamyplant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioMyPlant extends Pessoa {
    protected LojaMyPlant loja;
    protected double salarioBase;
    protected List<Double> salarioRecebido;

    public FuncionarioMyPlant(String nome, int idade, LojaMyPlant loja, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        salarioRecebido.add(salarioBase);
        salarioRecebido.add(salarioBase + 200);
        salarioRecebido.add(salarioBase + 300);
    }

    public void apresentarse() {
        System.out.println("Funcionário: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + loja.getNomeFantasia());
        endereco.apresentarLogradouro();
        System.out.println("Média Salarial: R$" + calcularMedia());
        System.out.println("Bônus: R$" + calcularBonus());
        System.out.println();
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        double media = salarioRecebido.isEmpty() ? 0 : soma / salarioRecebido.size();
        return arredondar(media);
    }

    public double calcularBonus() {
        return arredondar(salarioBase * 0.2);
    }

    protected double arredondar(double valor) {
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

   
    public LojaMyPlant getLoja() {
        return loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }
}
