public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, Vendedor[] vendedores, Cliente[] clientes) {
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
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public void printando() {
        System.out.println("Nome da loja: "+ nomeFantasia +"\nCNPJ da loja: "+cnpj+"\nEndereço da loja: "+cidade+", Bairro: "+bairro+", Rua: "+rua );
    }
}
