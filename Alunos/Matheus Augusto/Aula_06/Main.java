public class Main {
    public static void main(String[] args) {
        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", 
                               "São Paulo", "Centro", "Rua das Flores, 123");
        
        Vendedor vendedor1 = new Vendedor("João Silva", 25, myPlant, "São Paulo", 
                                         "Centro", "Rua A, 456", 2500.0);
        Vendedor vendedor2 = new Vendedor("Maria Santos", 30, myPlant, "São Paulo", 
                                         "Vila Madalena", "Rua B, 789", 2800.0);
        
        myPlant.adicionarVendedor(vendedor1);
        myPlant.adicionarVendedor(vendedor2);
        
        Cliente cliente1 = new Cliente("Carlos Oliveira", 35, "São Paulo", 
                                       "Jardins", "Rua C, 101");
        Cliente cliente2 = new Cliente("Ana Pereira", 28, "São Paulo", 
                                      "Moema", "Rua D, 202");
        Cliente cliente3 = new Cliente("Pedro Souza", 40, "São Paulo", 
                                      "Itaim Bibi", "Rua E, 303");
        
        myPlant.adicionarCliente(cliente1);
        myPlant.adicionarCliente(cliente2);
        myPlant.adicionarCliente(cliente3);
        
        System.out.println("=== Loja ===");
        myPlant.apresentarse();
        System.out.println("Total de vendedores: " + myPlant.contarVendedores());
        System.out.println("Total de clientes: " + myPlant.contarClientes());
        System.out.println();
        
        System.out.println("=== Vendedores ===");
        for (Vendedor vendedor : new Vendedor[]{vendedor1, vendedor2}) {
            vendedor.apresentarse();
            System.out.printf("Média salarial: R$%.2f\n", vendedor.calcularMedia());
            System.out.printf("Bônus: R$%.2f\n", vendedor.calcularBonus());
            System.out.println();
        }
        
        System.out.println("=== Clientes ===");
        for (Cliente cliente : new Cliente[]{cliente1, cliente2, cliente3}) {
            cliente.apresentarse();
            System.out.println();
        }
    }
}
