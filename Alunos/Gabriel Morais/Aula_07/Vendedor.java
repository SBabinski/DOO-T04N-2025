package entities;

import java.util.ArrayList;

public class Vendedor extends Pessoa {
    private String loja;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor() {}

    public Vendedor(String nome, int idade, Endereco endereco, String loja, double salarioBase, ArrayList<Double> salarioRecebido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
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
        return salarioBase * 0.2;
    }
}