
import java.util.ArrayList;

public class Loja {

    public String nome;
    public String razaoSocial;
    public String cnpj;
    public String cidade;
    public String bairro;
    public String rua;

    public ArrayList<Cliente> clientes = new ArrayList<>();
    public ArrayList<Vendedor> vendedores = new ArrayList<>();

    public Loja(String nome, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nome + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
}
