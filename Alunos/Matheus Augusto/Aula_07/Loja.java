public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private Funcionario[] vendedores;
    private Funcionario[] gerentes;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = new Vendedor[0];
        this.gerentes = new Gerente[0];
        this.clientes = new Cliente[0];
    }

    public void adicionarVendedor(Vendedor vendedor) {
        Vendedor[] novoArray = new Vendedor[vendedores.length + 1];
        System.arraycopy(vendedores, 0, novoArray, 0, vendedores.length);
        novoArray[vendedores.length] = vendedor;
        vendedores = novoArray;
    }

    public void adicionarGerente(Gerente gerente) {
        Gerente[] novoArray = new Gerente[gerentes.length + 1];
        System.arraycopy(gerentes, 0, novoArray, 0, gerentes.length);
        novoArray[gerentes.length] = gerente;
        gerentes = novoArray;
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

    public int contarGerentes() {
        return gerentes.length;
    }

    public void apresentarse() {
        System.out.println("Nome fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
