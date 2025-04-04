package entities;

import java.util.ArrayList;

public class Vendedor extends Cliente{
	private String loja;
	private double salarioBase;
	private ArrayList<Double> salarioRecebido;
	
	public Vendedor() {
		
	}
	
	
	public Vendedor(String nome, int idade, String cidade, String bairro, String rua, String loja, double salarioBase,
			ArrayList<Double> salarioRecebido) {
		super(nome, idade, cidade, bairro, rua);
		this.loja = loja;
		this.salarioBase = salarioBase;
		this.salarioRecebido = salarioRecebido;
	}
	
	@Override
	public String apresentarse() {
		return "Nome: " + getNome() + "Idade: " + getIdade() + "Loja: " + loja;
	}
	
	public double calcularMedia(){
		double soma = 0;
		for(double salario: salarioRecebido) {
			soma += salario;
		}
		
		return soma/salarioRecebido.size();
	}

	public double calcularBonus() {
		return salarioBase * 0.2;
	}
}
