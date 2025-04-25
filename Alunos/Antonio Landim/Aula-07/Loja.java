package entities;

import java.util.ArrayList;

public class Loja {

    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Clientes> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Clientes cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    public String getRazaoSocial() {
    	return razaoSocial;
    }
}

