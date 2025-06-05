import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Venda {
        int quantidade, dia, mes;
        double valorTotal;

        public Venda(int quantidade, double valorTotal, int dia, int mes) {
            this.quantidade = quantidade;
            this.valorTotal = valorTotal;
            this.dia = dia;
            this.mes = mes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();

        while (true) {
            System.out.println("\n[1] Registrar Venda");
            System.out.println("[2] Consultar Vendas por Dia");
            System.out.println("[3] Consultar Vendas por Mês");
            System.out.println("[4] Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Preço Unitário: ");
                double precoUnitario = scanner.nextDouble();
                double valorTotal = quantidade * precoUnitario;

                System.out.print("Dia da Venda: ");
                int dia = scanner.nextInt();
                System.out.print("Mês da Venda: ");
                int mes = scanner.nextInt();

                vendas.add(new Venda(quantidade, valorTotal, dia, mes));
                System.out.println("Venda registrada com sucesso!");

            } else if (opcao == 2) {
                System.out.print("Digite o dia para consultar as vendas: ");
                int diaConsulta = scanner.nextInt();
                double totalDia = 0;
                for (Venda v : vendas) {
                    if (v.dia == diaConsulta) {
                        totalDia += v.valorTotal;
                    }
                }
                System.out.printf("Total de vendas no dia %d: R$ %.2f\n", diaConsulta, totalDia);

            } else if (opcao == 3) {
                System.out.print("Digite o mês para consultar as vendas: ");
                int mesConsulta = scanner.nextInt();
                double totalMes = 0;
                for (Venda v : vendas) {
                    if (v.mes == mesConsulta) {
                        totalMes += v.valorTotal;
                    }
                }
                System.out.printf("Total de vendas no mês %d: R$ %.2f\n", mesConsulta, totalMes);

            } else if (opcao == 4) {
                break;
            }
        }

        scanner.close();
    }
}
