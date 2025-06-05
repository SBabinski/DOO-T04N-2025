public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new Vendedor[0];
        this.clientes = new Cliente[0];
    }

    public void adicionarVendedor(Vendedor vendedor) {
        Vendedor[] novoArray = new Vendedor[vendedores.length + 1];
        System.arraycopy(vendedores, 0, novoArray, 0, vendedores.length);
        novoArray[vendedores.length] = vendedor;
        vendedores = novoArray;
    }

    public void adicionarCliente(Cliente cliente) {
        Cliente[] novoArray = new Cliente[clientes.length + 1];
        System.arraycopy(clientes, 0, novoArray, 0, clientes.length);
        novoArray[clientes.length] = cliente;
        clientes = novoArray;
    }

    public int contarClientes() {
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public void apresentarse() {
        System.out.println("Nome fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + cidade + ", " + bairro + ", " + rua);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
