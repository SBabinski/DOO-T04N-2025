package entities;

import java.util.ArrayList;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        salarioRecebido.add(8000.0);
        salarioRecebido.add(8500.0);
        salarioRecebido.add(9000.0);
    }

    public String apresentarse() {
        return "Nome: " + nome + " Idade: " + idade + " Loja: " + loja;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return salarioRecebido.size() > 0 ? soma / salarioRecebido.size() : 0;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
