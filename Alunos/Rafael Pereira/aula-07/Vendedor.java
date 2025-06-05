package fag;

import java.util.*;

public class Vendedor extends Pessoa {
    private double salarioBase;
    private String loja;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Endereco endereco, double salarioBase, String loja) {
        super(nome, idade, endereco);
        this.salarioBase = salarioBase;
        this.loja = loja;
        this.salarioRecebido = Arrays.asList(3000.0, 3200.0, 3100.0);
    }

    @Override
    public void apresentarSe() {
        System.out.printf("[Vendedor] Nome: %s | Idade: %d | Loja: %s\n", getNome(), getIdade(), loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
