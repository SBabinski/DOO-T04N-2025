import java.util.ArrayList;
import java.util.Scanner;

class Venda {
    int quantidade, dia, mes;
    float valor, total, totalComDesconto;

    Venda(int quantidade, float valor, int dia, int mes) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.total = quantidade * valor;
        this.totalComDesconto = quantidade >= 10 ? total * 0.95f : total;
    }

    public String toString() {
        String resultado = "\nData: " + dia + "/" + mes +
                           "\nQtd: " + quantidade + 
                           "\nValor: R$" + String.format("%.2f", valor) +
                           "\nTotal sem desconto: R$" + String.format("%.2f", total);
        if (quantidade >= 10) {
            resultado += "\nDesconto de 5% aplicado!" +
                         "\nTotal com desconto: R$" + String.format("%.2f", totalComDesconto);
        }
        return resultado;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Venda> vendas = new ArrayList<>();
        int escolha;

        do {
            System.out.println("\n1 - Registrar Venda\n2 - Exibir Vendas\n3 - Buscar Vendas por Data\n4 - Sair");
            escolha = scanner.nextInt();

            if (escolha == 1) {
                System.out.print("Dia da venda: ");
                int dia = scanner.nextInt();
                System.out.print("Mês da venda: ");
                int mes = scanner.nextInt();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Valor: ");
                float valor = scanner.nextFloat();
                vendas.add(new Venda(quantidade, valor, dia, mes));
                System.out.println("Venda registrada!");
            } else if (escolha == 2) {
                if (vendas.isEmpty()) System.out.println("Nenhuma venda registrada.");
                else vendas.forEach(System.out::println);
            } else if (escolha == 3) {
                System.out.print("Digite o dia: ");
                int diaBusca = scanner.nextInt();
                System.out.print("Digite o mês: ");
                int mesBusca = scanner.nextInt();

                float totalDia = 0;
                for (Venda venda : vendas) {
                    if (venda.dia == diaBusca && venda.mes == mesBusca) {
                        totalDia += venda.totalComDesconto;
                        System.out.println(venda);
                    }
                }

                if (totalDia == 0) System.out.println("Nenhuma venda encontrada para esta data.");
                else System.out.printf("Total de vendas no dia %d/%d: R$%.2f%n", diaBusca, mesBusca, totalDia);
            }
        } while (escolha != 4);

        System.out.println("Encerrando...");
        scanner.close();
    }
}
