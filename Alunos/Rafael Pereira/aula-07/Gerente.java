package fag;

import java.util.*;

public class Gerente extends Pessoa {
    private double salarioBase;
    private String loja;
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, Endereco endereco, double salarioBase, String loja) {
        super(nome, idade, endereco);
        this.salarioBase = salarioBase;
        this.loja = loja;
        this.salarioRecebido = Arrays.asList(5000.0, 5200.0, 5100.0);
    }

    @Override
    public void apresentarSe() {
        System.out.printf("[Gerente] Nome: %s | Idade: %d | Loja: %s\n", getNome(), getIdade(), loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
