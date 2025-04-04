package gabrielinha;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    int id;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    Vendedor[] vendedores = new Vendedor[10]; // Exemplo de tamanho fixo
    Cliente[] clientes = new Cliente[10];
    int totalVendedores = 0;
    int totalClientes = 0;

    void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    void adicionarVendedor(Vendedor vendedor) {
        if (totalVendedores < vendedores.length) {
            vendedores[totalVendedores++] = vendedor;
        } else {
            System.out.println("Capacidade máxima de vendedores atingida.");
        }
    }

    void adicionarCliente(Cliente cliente) {
        if (totalClientes < clientes.length) {
            clientes[totalClientes++] = cliente;
        } else {
            System.out.println("Capacidade máxima de clientes atingida.");
        }
    }

    int contarClientes() {
        return totalClientes;
    }

    int contarVendedores() {
        return totalVendedores;
    }

}