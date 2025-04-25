package sistemamyplant;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal {
    public static void main(String[] args) {
        
        Endereco enderecoLoja = new Endereco("SC", "Florianópolis", "Centro", 123, "Rua das Flores");
        LojaMyPlant loja = new LojaMyPlant("My Plant", "My Plant LTDA", "12.345.678/0001-90", enderecoLoja);

        
        FuncionarioMyPlant vendedor1 = criarVendedor("Lucas", 28, loja, "Centro", 100, "Rua das Violetas", 1800);
        FuncionarioMyPlant vendedor2 = criarVendedor("Marina", 32, loja, "Trindade", 101, "Rua dos Lírios", 2000);

        
        loja.adicionarFuncionario(vendedor1);
        loja.adicionarFuncionario(vendedor2);

      
        ClienteMyPlant cliente1 = criarCliente("João", 45, "Estreito", 202, "Rua das Begônias");
        ClienteMyPlant cliente2 = criarCliente("Clara", 22, "São José", 303, "Rua das Rosas");

     
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

       
        loja.apresentarse();

     
        System.out.println("\n--- Funcionários ---");
        apresentarFuncionario(vendedor1);
        apresentarFuncionario(vendedor2);

       
        System.out.println("\n--- Clientes ---");
        cliente1.apresentarse();
        cliente2.apresentarse();

        
        System.out.println("\nTotal de Funcionários: " + loja.contarFuncionarios());
        System.out.println("Total de Clientes: " + loja.contarClientes());

      
        System.out.println("\n--- Criando Pedido ---");
        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, cliente1, vendedor1, loja);

    
        pedido.gerarDescricaoVenda();

       
        processaPedido.testarPagamento(pedido);
    }

    
    private static FuncionarioMyPlant criarVendedor(String nome, int idade, LojaMyPlant loja, String bairro, int numero, String rua, double salarioBase) {
        Endereco endereco = new Endereco("SC", "Florianópolis", bairro, numero, rua);
        return new FuncionarioMyPlant(nome, idade, loja, endereco, salarioBase);
    }

    
    private static ClienteMyPlant criarCliente(String nome, int idade, String bairro, int numero, String rua) {
        Endereco endereco = new Endereco("SC", "Florianópolis", bairro, numero, rua);
        return new ClienteMyPlant(nome, idade, endereco);
    }

    
    private static void apresentarFuncionario(FuncionarioMyPlant vendedor) {
        vendedor.apresentarse();
        System.out.println("Média Salarial: R$" + vendedor.calcularMedia());
        System.out.println("Bônus: R$" + vendedor.calcularBonus());
        System.out.println();
    }
}
