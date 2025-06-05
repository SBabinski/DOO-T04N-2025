package Aula06;

import java.util.ArrayList;
import java.util.List;

public class Salario {
    private String nome;
    private String idade;
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    
    public Salario(String nome, String idade, String loja, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        
        salarioRecebido.add(salarioBase + 200);
        salarioRecebido.add(salarioBase + 100);
        salarioRecebido.add(salarioBase + 300);
    }

    
    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        double media = soma / salarioRecebido.size();  // Usando o tamanho da lista
        System.out.println("Média dos salários de " + nome + ": R$" + media);
        return media;
    }

   
    public double calcularBonus() {
        double bonus = salarioBase * 0.2;  // Calculando o bônus de 20%
        System.out.println("Bônus de " + nome + ": R$" + bonus);
        return bonus;
    }
}
