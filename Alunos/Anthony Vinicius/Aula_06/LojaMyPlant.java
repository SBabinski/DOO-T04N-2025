package sistemamyplant;

import java.util.ArrayList;
import java.util.List;

public class LojaMyPlant {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<FuncionarioMyPlant> funcionarios;
    private List<ClienteMyPlant> clientes;

    public LojaMyPlant(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
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
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarFuncionarios() {
        return funcionarios.size();
    }
}
