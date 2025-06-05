package Aula06;

public class Principal {
    public static void main(String[] args) {
        
        Loja loja1 = new Loja("Tech Shop", "Tech Shop LTDA", "12.345.678/0001-99", 
                              "São Paulo", "Centro", "Rua da Tecnologia");

      
        Vendedor vendedor1 = new Vendedor("Carlos", 30, "Tech Shop", "São Paulo", "Centro", "Rua da Tecnologia", 3000.00);
        Vendedor vendedor2 = new Vendedor("Ana", 25, "Tech Shop", "São Paulo", "Centro", "Rua da Tecnologia", 2800.00);

        
        Cliente cliente1 = new Cliente("Bruno", 40, "São Paulo", "Centro", "Rua dos Clientes");
        Cliente cliente2 = new Cliente("Luciana", 35, "São Paulo", "Centro", "Rua dos Clientes");

        
        loja1.adicionarVendedor(vendedor1);
        loja1.adicionarVendedor(vendedor2);
        loja1.adicionarCliente(cliente1);
        loja1.adicionarCliente(cliente2);

    
        System.out.println("\n--- Apresentação da Loja ---");
        loja1.apresentarse();

        System.out.println("\n--- Apresentação dos Vendedores ---");
        vendedor1.apresentarse();
        vendedor1.calcularMedia();
        vendedor1.calcularBonus();

        vendedor2.apresentarse();
        vendedor2.calcularMedia();
        vendedor2.calcularBonus();

        System.out.println("\n--- Apresentação dos Clientes ---");
        cliente1.apresentarse();
        cliente2.apresentarse();

        System.out.println("\n--- Contagem de Pessoas na Loja ---");
        loja1.contarVendedores();
        loja1.contarClientes();
    }
}