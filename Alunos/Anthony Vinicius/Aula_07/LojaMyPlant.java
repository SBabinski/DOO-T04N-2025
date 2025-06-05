package sistemamyplant;

import java.util.ArrayList;
import java.util.List;

public class LojaMyPlant {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private List<FuncionarioMyPlant> funcionarios;
    private List<ClienteMyPlant> clientes;

    public LojaMyPlant(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarFuncionario(FuncionarioMyPlant f) {
        funcionarios.add(f);
    }

    public void adicionarCliente(ClienteMyPlant c) {
        clientes.add(c);
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + " | CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarFuncionarios() {
        return funcionarios.size();
    }
    
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }
}
