package entities;

import java.util.ArrayList;

public class Loja {
	
	private String nomeFantasia;
	private String razaoSozial;
	private Integer cnpj;
	private String cidade;
	private String bairro;
	private String rua;
	private ArrayList<Vendedor> vendedores = new ArrayList<>();
	private ArrayList<Clientes> clientes= new ArrayList<>();
	
	public Loja() {
		this.vendedores = new ArrayList<>();
	    this.clientes = new ArrayList<>();
		
	}

	public Loja(String nomeFantasia, String razaoSozial, Integer cnpj, String cidade, String bairro, String rua,
			ArrayList<Vendedor> vendedores, ArrayList<Clientes> clientes) {
		this.nomeFantasia = "MyPlant";
		this.razaoSozial = "MyPlant Comércio de plantas LTDA";
		this.cnpj = 123456789;
		this.cidade = "Cascavel";
		this.bairro = "Floresta";
		this.rua = "Papagaios";
		this.vendedores = vendedores;
		this.clientes = clientes;
	}
	
	public String apresentarse() {
		return "Nome: " + nomeFantasia + " CNPJ: " + cnpj + " Endereço: " + cidade + bairro + rua;
	}
	
	public int contarClientes() {
		return clientes.size();
		}
	

	public int contarVendedores() {
		return vendedores.size();
	}
	
	public void adicionarFuncionario(Vendedor vendedor) {
		vendedores.add(vendedor);
		System.out.println("Funcionário adicionado! ");
	}
	
	public void listarFuncionarios() {
		for(Vendedor v : vendedores) {
			System.out.println(v.apresentarse());
		}
	}
	
	public void adicionarClientes(Clientes cliente) {
		clientes.add(cliente);
		System.out.println("Cliente adicionado! ");
	}
	
	public void listarClientes() {
		for(Clientes c : clientes) {
			System.out.println(c.apresentarse());
		}
	}
}
