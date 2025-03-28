package atividade4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Atividade_Aula_04 {
    static Scanner scan = new Scanner(System.in);
    public static List<String> registroVenda = new ArrayList<String>();

    public static void main(String[] args) {
        boolean menu = true;
        while (menu) {
            System.out.println("Olá, o que gostaria de fazer? \n(1) - Calcular preço total: \n(2) - Calcular troco: \n(3) - Visualizar registro de vendas: \n(4) - Buscar vendas por data: \n(5) - Sair.");
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    calcularPreco();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    registroVendas();
                    break;
                case 4:
                    buscarVendasPorData();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void calcularPreco() {
        scan.nextLine();
        System.out.println("Entre com o mês da venda: ");
        int mes = scan.nextInt();
        System.out.println("Entre com o dia da venda: ");
        int dia = scan.nextInt();
        System.out.println("Entre com a quantidade do produto: ");
        int quantidade = scan.nextInt();
        System.out.println("Entre com o valor do produto: ");
        float valor = scan.nextFloat();

        float valorTotal = quantidade * valor;
        float desconto = 0;
        if (quantidade > 10) {
            desconto = valorTotal * 0.05f;
            valorTotal -= desconto;
        }
        System.out.printf("O valor final é %.2f \n", valorTotal);

        String venda = String.format("%02d/%02d | Quantidade: %d | Total: R$%.2f | Desconto: R$%.2f", mes, dia, quantidade, valorTotal, desconto);
        registroVenda.add(venda);
    }

    public static void calcularTroco() {
        scan.nextLine();
        System.out.println("Entre com o valor pago pelo cliente: ");
        float valorPago = scan.nextFloat();
        System.out.println("Entre com o valor da compra: ");
        float valorCompra = scan.nextFloat();

        float valorTroco = valorPago - valorCompra;
        System.out.printf("O valor do troco é %.2f. \n", valorTroco);
    }

    public static void registroVendas() {
        if (registroVenda.isEmpty()) {
            System.out.println("Nenhuma venda foi feita.\n");
        } else {
            for (String venda : registroVenda) {
                System.out.println(venda);
            }
        }
    }

    public static void buscarVendasPorData() {
        System.out.println("Entre com o mês para buscar as vendas: ");
        int mesBusca = scan.nextInt();
        System.out.println("Entre com o dia para buscar as vendas: ");
        int diaBusca = scan.nextInt();

        boolean encontrou = false;
        for (String venda : registroVenda) {
            String[] partes = venda.split(" | ");
            String dataVenda = partes[0];
            String[] dataPartes = dataVenda.split("/");

            int mesVenda = Integer.parseInt(dataPartes[0]);
            int diaVenda = Integer.parseInt(dataPartes[1]);

            if (mesVenda == mesBusca && diaVenda == diaBusca) {
                System.out.println(venda);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma venda encontrada para essa data.");
        }
    }
}