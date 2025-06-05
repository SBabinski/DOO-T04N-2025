import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar Gerente");
            System.out.println("2. Criar Pedido (dados fakes)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Endereco end = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", 123, "Ap 10");
                    Gerente gerente = new Gerente("Maria", 35, "Loja A", 4000.00, end);
                    gerente.apresentarSe();
                    end.apresentarLogradouro();
                    System.out.println("Média Salarial: R$ " + gerente.calcularMedia());
                    System.out.println("Bônus: R$ " + gerente.calcularBonus());
                    break;

                case 2:
                    ProcessaPedido proc = new ProcessaPedido();
                    Pedido pedido = proc.processar(101, "João", "Carlos", "Loja A");
                    pedido.gerarDescricaoVenda();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
