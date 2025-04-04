package entities;

import java.util.ArrayList;

public class Loja {

	private String nomeFantasia;
	private String razaoSocial;
	private int cnpj;
	private String cidade;
	private String bairro;
	private String rua;
	private ArrayList<Vendedor> vendedores = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public Loja() {
		
	}

	public Loja(String nomeFantasia, String razaoSocial, int cnpj, String cidade, String bairro, String rua,
			ArrayList<Vendedor> vendedores, ArrayList<Cliente> clientes) {
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.vendedores = vendedores;
		this.clientes = clientes;
	}
	
	
	public int contarClientes() {
		return clientes.size();
	}
	
	public int contarVendedor() {
		return vendedores.size();
	}
	
	public String apresentarse() {
		return "Nome fantasia: " + nomeFantasia + "CNPJ: " + cnpj + "Endereço: " + cidade + ", " + bairro + ", " + rua + ".";
	}
}
