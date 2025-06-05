package aula07;

import java.util.Arrays;
import java.util.List;

public class Gerente extends Pessoa {
	    String loja;
	    double salarioBase;
	    List<Double> salarioRecebido;

	    public Gerente(String nome, int idade, String loja, double salarioBase) {
	        super(nome, idade);
	        this.loja = loja;
	        this.salarioBase = salarioBase;
	        this.salarioRecebido = Arrays.asList(3000.0, 3100.0, 3200.0); 
	    }

	    public void apresentarse() {
	        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
	    }

	    public double calcularMedia() {
	        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
	    }

	    public double calcularBonus() {
	        return salarioBase * 0.35;
	    }
	}
