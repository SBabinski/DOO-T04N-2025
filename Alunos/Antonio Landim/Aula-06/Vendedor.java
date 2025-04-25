package entities;

import java.util.ArrayList;

public class Vendedor extends Clientes{

		private String loja;
		private Double salarioBase;
		private ArrayList<Double> salarioRecebido;
		
		public Vendedor() {
			
		}
		
		public Vendedor(String nome, Integer idade, String loja, String cidade, String bairro, String rua, Double salarioBase,
				ArrayList<Double> salarioRecebido) {
			super(nome, idade, cidade, bairro, rua);
			this.loja = loja;
			this.salarioBase = salarioBase;
			this.salarioRecebido = new ArrayList<>();
			
			this.salarioRecebido.add(2500.0);
			this.salarioRecebido.add(2600.0);
			this.salarioRecebido.add(2850.0);
			
		}
		
		@Override
		public String apresentarse() {
			return "Nome: " + getNome() + " Idade: " + getIdade() + " Loja: " + loja;
		}
		
		public double calcularMedia() {
			double soma = 0;
			for(double salario : salarioRecebido) {
				soma += salario;
			}
			
			return soma / salarioRecebido.size();
		}
		
		public double calcularBonus() {
			return salarioBase * 0.2;
		}
		
}