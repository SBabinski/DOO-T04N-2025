package entities;

import java.util.ArrayList;

public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private double salarioBase;
    private Endereco endereco;
    private ArrayList<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, Loja loja, double salarioBase, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.endereco = endereco;
    }

    public void adicionarSalario(double salario) {
        salarioRecebido.add(salario);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public double calcularMedia() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return salarioRecebido.size() > 0 ? total / salarioRecebido.size() : 0;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
