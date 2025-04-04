package gabrielinha;

import java.util.ArrayList;
import java.util.Scanner;
import gabrielinha.Vendedor;
import gabrielinha.Cliente;
import gabrielinha.Loja;

public class lojagabrielinha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--- Menu ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Registrar Vendedor");
            System.out.println("[3] - Registrar Cliente");
            System.out.println("[4] - Registrar Loja");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade da planta: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço unitário da planta: ");
                    double preco = scanner.nextDouble();
                    double precoTotal = quantidade * preco;
                    double desconto = (quantidade > 10) ? precoTotal * 0.05 : 0;
                    double valorFinal = precoTotal - desconto;
                    System.out.printf("Preço total: R$ %.2f\n", valorFinal);
                    if (desconto > 0) {
                        System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
                    }
                    break;

                case 2:
                    System.out.print("Nome do vendedor: ");
                    scanner.nextLine(); // limpar buffer
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeVendedor = scanner.nextInt();
                    System.out.print("Salário base: ");
                    double salarioBase = scanner.nextDouble();
                    Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, "Minha Loja", "Cidade", "Bairro", "Rua", salarioBase);
                    vendedor.apresentarse();
                    System.out.printf("Média Salarial: R$ %.2f\n", vendedor.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", vendedor.calcularBonus());
                    break;

                case 3:
                    System.out.print("Nome do cliente: ");
                    scanner.nextLine();
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeCliente = scanner.nextInt();
                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, "Cidade", "Bairro", "Rua");
                    cliente.apresentarse();
                    break;

                case 4:
                    System.out.print("Nome Fantasia da Loja: ");
                    scanner.nextLine();
                    String nomeFantasia = scanner.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = scanner.nextLine();
                    Loja loja = new Loja(nomeFantasia, cnpj, "Cidade", "Bairro", "Rua", new ArrayList<>(), new ArrayList<>());
                    loja.apresentarse();
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
        scanner.close();
    }
}

