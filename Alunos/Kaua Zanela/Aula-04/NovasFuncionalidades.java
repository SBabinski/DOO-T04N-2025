package teste;

import java.util.ArrayList;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double total;
    double desconto;
    String data;

    Venda(int quantidade, double precoUnitario, double total, double desconto, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.desconto = desconto;
        this.data = data;
    }
}

public class Teste1 {
    static ArrayList<Venda> vendas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Calculadora Dona Gabrielinha =====");
            System.out.println("1 - Calcular Preço Total e Registrar Venda");
            System.out.println("2 - Consultar Vendas por Data");
            System.out.println("3 - Calcular Troco");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    consultarVendasPorData();
                    break;
                case 3:
                    calcularTroco();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    static void calcularPrecoTotal() {
        System.out.print("Quantidade de plantas: ");
        int quantidade = input.nextInt();
        System.out.print("Preço unitário: ");
        double preco = input.nextDouble();
        input.nextLine();
        System.out.print("Data da venda (DD/MM): ");
        String data = input.nextLine();

        double total = quantidade * preco;
        double desconto = 0;
        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        }
        System.out.printf("Total a pagar: R$ %.2f\n", total);

        vendas.add(new Venda(quantidade, preco, total, desconto, data));
    }

    static void consultarVendasPorData() {
        System.out.print("Digite a data para consulta (DD/MM): ");
        String dataConsulta = input.nextLine();
        int totalPlantas = 0;
        for (Venda venda : vendas) {
            if (venda.data.equals(dataConsulta)) {
                totalPlantas += venda.quantidade;
            }
        }
        System.out.println("Total de plantas vendidas em " + dataConsulta + ": " + totalPlantas);
    }

    static void calcularTroco() {
        System.out.print("Valor recebido: ");
        double valorRecebido = input.nextDouble();
        System.out.print("Valor da compra: ");
        double valorCompra = input.nextDouble();
        input.nextLine();
        if (valorRecebido >= valorCompra) {
            double troco = valorRecebido - valorCompra;
            System.out.printf("Troco: R$ %.2f\n", troco);
        } else {
            System.out.println("Valor insuficiente!");
        }
    }
}
