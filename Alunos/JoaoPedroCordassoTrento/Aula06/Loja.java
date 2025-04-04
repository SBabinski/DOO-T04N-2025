package classes;

import java.util.ArrayList;

public class Loja {
    private int idLoja;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList <Vendedor> listaDeVendedoresLoja = new ArrayList<>();
    private ArrayList <Cliente> listaDeClientesLoja = new ArrayList<>();
    
    public int getIdLoja() {
        return idLoja;
    }
    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public ArrayList<Vendedor> getlistaDeVendedoresLoja() {
        return listaDeVendedoresLoja;
    }
    public void setlistaDeVendedoresLoja(ArrayList<Vendedor> listaDeVendedoresLoja) {
        this.listaDeVendedoresLoja = listaDeVendedoresLoja;
    }
    public ArrayList<Cliente> getlistaDeClientesLoja() {
        return listaDeClientesLoja;
    }
    public void setlistaDeClientesLoja(ArrayList<Cliente> listaDeClientesLoja) {
        this.listaDeClientesLoja = listaDeClientesLoja;
    }
    public Loja() {
        super();
    }
    public Loja(int idLoja, String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro,
                String rua) {
        this.idLoja = idLoja;
        this.nomeFantasia = nomeFantasia; 
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        // this.listaDeVendedoresLoja = listaDeVendedoresLoja;
        // this.listaDeClientesLoja = listaDeClientesLoja;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getIdLoja() + 
           ", Nome Fantasia: " + getNomeFantasia() + 
           ", Razão Social: " + getRazaoSocial() + 
           ", CNPJ: " + getCnpj() + 
           ", Cidade: " + getCidade() + 
           ", Bairro: " + getBairro() + 
           ", Rua: " + getRua() +
           ", Vendedores: " + exibirNomeVendedores() + 
           "Clientes: " + exibirNomeClientes() +
           "\n";
    }

    public void apresentar() {
        System.out.println("Nome fantasia: " + getNomeFantasia() + ", CNPJ: " + getCnpj() + 
                        ", Endereço: " + getCidade() + ", " + getBairro() + ", " + getRua());
    }
    public void contarVendedores() {
        int qtdVendedores = 0;
        for (Vendedor vendedor : listaDeVendedoresLoja) {
            System.out.println(vendedor);
            qtdVendedores++;
        }
        System.out.println("Na loja " + getNomeFantasia() + " temos " + qtdVendedores + " vendedores");
    }
    public void contarClientes() {
        int qtdClientes = 0;
        for (Cliente cliente : listaDeClientesLoja) {
            System.out.println(cliente);
            qtdClientes++;
        }
        System.out.println("Na loja " + getNomeFantasia() + " temos " + qtdClientes + " vendedores");
    }
    public String exibirNomeVendedores() {
        StringBuilder vendedoresStr = new StringBuilder();
        for (Vendedor vendedor : listaDeVendedoresLoja) {
            vendedoresStr.append(vendedor.getNome()).append(", ");
        }
        return vendedoresStr.toString().isEmpty() ? "Nenhum cliente cadastrado" : vendedoresStr.toString();
    }
    public String exibirNomeClientes() {
        StringBuilder clientesStr = new StringBuilder();
        for (Cliente cliente : listaDeClientesLoja) {
            clientesStr.append(cliente.getNome()).append(", ");
        }
        return clientesStr.toString().isEmpty() ? "Nenhum cliente cadastrado" : clientesStr.toString();
    }
}