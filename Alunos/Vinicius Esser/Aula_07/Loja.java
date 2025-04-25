package Aula_07;

import java.util.List;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Endereço endereco;
    List<Vendedor> vendedores;
    List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereço endereco,
                List<Vendedor> vendedores, List<Cliente> clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + " | CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }
}
