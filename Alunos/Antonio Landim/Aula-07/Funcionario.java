package entities;

import java.util.ArrayList;

public class Funcionario extends Clientes {
	
	private String loja;
	private Double salarioBase;
	private ArrayList<Double> salarioRecebido;
	

	public Funcionario(String nome, Integer idade, Endereco endereco, String loja, Double salarioBase,
			ArrayList<Double> salarioRecebido) {
		super(nome, idade, endereco);
		this.loja = loja;
		this.salarioBase = salarioBase;
		this.salarioRecebido = salarioRecebido;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public ArrayList<Double> getSalarioRecebido() {
		return salarioRecebido;
	}

	public void setSalarioRecebido(ArrayList<Double> salarioRecebido) {
		this.salarioRecebido = salarioRecebido;
	}
	
	
}
