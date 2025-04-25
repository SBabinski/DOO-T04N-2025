import java.util.ArrayList;

public class Loja {
    private int idLoja;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private ArrayList <Gerente> listaDeGerentesLoja = new ArrayList<>();
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
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Gerente> getListaDeGerentesLoja() {
        return listaDeGerentesLoja;
    }
    public void setListaDeGerentesLoja(ArrayList<Gerente> listaDeGerentesLoja) {
        this.listaDeGerentesLoja = listaDeGerentesLoja;
    }
    public ArrayList<Vendedor> getListaDeVendedoresLoja() {
        return listaDeVendedoresLoja;
    }
    public void setListaDeVendedoresLoja(ArrayList<Vendedor> listaDeVendedoresLoja) {
        this.listaDeVendedoresLoja = listaDeVendedoresLoja;
    }
    public ArrayList<Cliente> getListaDeClientesLoja() {
        return listaDeClientesLoja;
    }
    public void setListaDeClientesLoja(ArrayList<Cliente> listaDeClientesLoja) {
        this.listaDeClientesLoja = listaDeClientesLoja;
    }
    public Loja() {
        super();
    }
    public Loja(int idLoja, String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.idLoja = idLoja;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "ID da Loja: " + getIdLoja() +
           ", Nome Fantasia: " + getNomeFantasia() + 
           ", Razao Social: " + getRazaoSocial() + 
           ", CNPJ: " + getCnpj() +
           ", Endereco: " + getEndereco() + 
           ", Vendedores: " + exibirNomeVendedores() + 
           "Clientes: " + exibirNomeClientes() +
           "\n";
    }
    
    public void apresentar() {
        System.out.println("Nome fantasia: " + getNomeFantasia() + ", CNPJ: " + getCnpj() + 
                        ", Endereço: " + getEndereco());
    }
    public void contarGerentes() {
        int qtdGerentes = 0;
        for (Gerente gerente : listaDeGerentesLoja) {
            System.out.println(gerente);
            qtdGerentes++;
        }
        System.out.println("Na loja " + getNomeFantasia() + " temos " + qtdGerentes + " gerentes");
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
        System.out.println("Na loja " + getNomeFantasia() + " temos " + qtdClientes + " clientes");
    }
    public String exibirNomeGerentes() {
        StringBuilder gerentesStr = new StringBuilder();
        for (Gerente gerente : listaDeGerentesLoja) {
            gerentesStr.append(gerente.getNome()).append(", ");
        }
        return gerentesStr.toString().isEmpty() ? "Nenhum gerente cadastrado" : gerentesStr.toString();
    }
    public String exibirNomeVendedores() {
        StringBuilder vendedoresStr = new StringBuilder();
        for (Vendedor vendedor : listaDeVendedoresLoja) {
            vendedoresStr.append(vendedor.getNome()).append(", ");
        }
        return vendedoresStr.toString().isEmpty() ? "Nenhum vendedor cadastrado" : vendedoresStr.toString();
    }
    public String exibirNomeClientes() {
        StringBuilder clientesStr = new StringBuilder();
        for (Cliente cliente : listaDeClientesLoja) {
            clientesStr.append(cliente.getNome()).append(", ");
        }
        return clientesStr.toString().isEmpty() ? "Nenhum cliente cadastrado" : clientesStr.toString();
    }
}
