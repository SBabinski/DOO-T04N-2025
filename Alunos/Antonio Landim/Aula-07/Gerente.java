package entities;

import java.util.ArrayList;

public class Gerente {

    private String nome;
    private int idade;
    private Loja loja;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;
    private Endereco endereco;

    public Gerente(String nome, int idade, Loja loja, double salarioBase, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.endereco = endereco;

        this.salarioRecebido = new ArrayList<>();
        salarioRecebido.add(5000.0);
        salarioRecebido.add(5200.0);
        salarioRecebido.add(5100.0);
    }

    public void apresentarse() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade);
        System.out.println("Loja: " + loja.getNomeFantasia());
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
        return salarioBase * 0.35;
    }
}

