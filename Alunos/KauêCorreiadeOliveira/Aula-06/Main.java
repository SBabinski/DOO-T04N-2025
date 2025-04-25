import java.util.Scanner;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Loja myPlant = new Loja("My Plant", "My Plant LOJA",
         "05.654.618/0007-10", "Cascavel", "Centro", "Rua Antônio Alves Massaneiro");

        Vendedor vendedor1 = new Vendedor("Ana", 28, "My Plant", "Cascavel",
         "Centro", "Rua Antônio Alves Massaneiro", 3000.0);

        Vendedor vendedor2 = new Vendedor("Carlos", 32, "My Plant",
         "Cascavel", "Centro", "Rua Antônio Alves Massaneiro", 3200.0);

        Cliente cliente1 = new Cliente("Beatriz", 25, "Cascavel",
         "Maria Luiza", "Rua Hyeda Baggio Mayer");
         
        Cliente cliente2 = new Cliente("João", 35, "Cascavel", "Centro", "Rua Afonso Pena");

        myPlant.adicionaVendedor(vendedor1);
        myPlant.adicionaVendedor(vendedor2);
        myPlant.adicionaCliente(cliente1);
        myPlant.adicionaCliente(cliente2);

        int opcao = 0;
        do {
            System.out.println("\nMenu My Plant");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Ver todos os vendedores");
            System.out.println("3. Ver todos os clientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1 -> {
                    myPlant.apresentarse();
                    myPlant.contarVendedores();
                    myPlant.contarClientes();
                }

                case 2 -> {
                    System.out.println("Vendedores:");
                    for (Vendedor v : myPlant.vendedores) {
                        v.apresentarse();
                        System.out.println("Média salarial: R$" + v.calcularMedia());
                        System.out.println("Bônus: R$" + v.calcularBonus());
                        
                    }
                }

                case 3 -> {
                    System.out.println("Clientes:");
                    for (Cliente c : myPlant.clientes) {
                        c.apresentarse();
                        
                    }
                }

                case 4 -> System.out.println("Saindo do sistema...");

                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}