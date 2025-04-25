package entities;

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private int cnpj;
    private Endereco endereco;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, int cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedor() {
        return vendedores.size();
    }

    public String apresentarse() {
        return "Nome fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", " + endereco.apresentarLogradouro();
    }
}