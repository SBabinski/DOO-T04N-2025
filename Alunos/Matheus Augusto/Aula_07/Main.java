import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Centro", "123", "Loja 1");
        
        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", enderecoLoja);
        
        Endereco enderecoVendedor = new Endereco("SP", "São Paulo", "Centro", "456", "Apto 101");
        Vendedor vendedor1 = new Vendedor("João Silva", 25, enderecoVendedor, myPlant, 2500.0);
        
        Endereco enderecoGerente = new Endereco("SP", "São Paulo", "Vila Madalena", "789", "Casa 2");
        Gerente gerente1 = new Gerente("Maria Santos", 30, enderecoGerente, myPlant, 5000.0);
        
        myPlant.adicionarVendedor(vendedor1);
        myPlant.adicionarGerente(gerente1);
        
        Endereco enderecoCliente = new Endereco("SP", "São Paulo", "Jardins", "101", "Apto 302");
        Cliente cliente1 = new Cliente("Carlos Oliveira", 35, enderecoCliente);
        myPlant.adicionarCliente(cliente1);
        
        Item item1 = new Item(1, "Vaso de Cerâmica", "Decoração", 89.90);
        Item item2 = new Item(2, "Suculenta", "Planta", 24.50);
        
        Date hoje = new Date();
        Date vencimento = new Date(hoje.getTime() + (7 * 24 * 60 * 60 * 1000)); 
        
        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(1, hoje, vencimento, cliente1, vendedor1, myPlant, 
                                             new Item[]{item1, item2});
        
        System.out.println("=== Loja ===");
        myPlant.apresentarse();
        System.out.println("\n=== Funcionários ===");
        vendedor1.apresentarse();
        System.out.printf("Bônus: R$%.2f\n", vendedor1.calcularBonus());
        gerente1.apresentarse();
        System.out.printf("Bônus: R$%.2f\n", gerente1.calcularBonus());
        
        System.out.println("\n=== Pedido ===");
        pedido.gerarDescricaoVenda();
        System.out.println("\n=== Itens ===");
        item1.gerarDescricao();
        item2.gerarDescricao();
    }
}
