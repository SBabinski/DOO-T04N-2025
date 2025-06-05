package Aula06;

import java.util.ArrayList;

		class Vendedor {
		    String nome;
		    int idade;
		    String loja;
		    String cidade;
		    String bairro;
		    String rua;
		    double salarioBase;
		    ArrayList<Double> salarioRecebido;

		    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
		        this.nome = nome;
		        this.idade = idade;
		        this.loja = loja;
		        this.cidade = cidade;
		        this.bairro = bairro;
		        this.rua = rua;
		        this.salarioBase = salarioBase;
		        this.salarioRecebido = new ArrayList<>();
		        
		    }

			public void calcularMedia() {
				// TODO Auto-generated method stub
				
			}

			public void calcularBonus() {
				// TODO Auto-generated method stub
				
			}

			public void apresentarse() {
				// TODO Auto-generated method stub
				
			}
		}
