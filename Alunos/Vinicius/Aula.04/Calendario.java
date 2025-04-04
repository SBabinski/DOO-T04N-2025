import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraAntiquada {
    public static void main(String[] args) {
        int opcao = 0;
        int contador = 0;
        Map<String, Double> vendasDiarias = new HashMap<>(); 
        Scanner scanner = new Scanner(System.in);
        
        while (opcao != 5) {
            System.out.println("1- Cálculo de preço total \n2- Calculo de troco \n3- Registro de compras \n4- Buscar vendas por dia \n5- Sair"); 
            opcao = scanner.nextInt();
        
            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: ");
                    int qtdPlantas = scanner.nextInt();
                    System.out.println("Digite o valor das plantas: ");
                    int valorPlantas = scanner.nextInt();
        
                    if (qtdPlantas > 10) {
                        double valorTotal = qtdPlantas * valorPlantas;
                        valorTotal *= 0.95;
                        System.out.println("Valor total com desconto de 5%: " + valorTotal);
                        registroVenda(qtdPlantas, valorTotal, vendasDiarias);
                    } else {
                        double valorTotal = qtdPlantas * valorPlantas;
                        System.out.println("Valor total: " + valorTotal);
                        registroVenda(qtdPlantas, valorTotal, vendasDiarias);
                    }
                    contador += 1;
                    break;
        
                case 2:
                    System.out.println("Digite o valor pago pelo cliente: ");
                    int n2 = scanner.nextInt();
                    System.out.println("Digite o valor total da compra: ");
                    int n1 = scanner.nextInt();
                    if (n2 >= n1) {
                        n2 = n2 - n1;
                        System.out.println("É necessário troco de " + n2);
                    } else {
                        n1 = n1 - n2;
                        System.out.println("Cliente ainda está devendo " + n1);
                    }
                    break;

                case 3:
                    System.out.println("Digite o mês (MM): ");
                    String mes = scanner.next();
                    System.out.println("Digite o dia (DD): ");
                    String dia = scanner.next();
                    String data = mes + "-" + dia;
                    System.out.println("Digite a quantidade de plantas: ");
                    int qtdPlantasCompra = scanner.nextInt();
                    System.out.println("Digite o valor das plantas: ");
                    int valorPlantasCompra = scanner.nextInt();

                    if (qtdPlantasCompra > 10) {
                        double valorTotalCompra = qtdPlantasCompra * valorPlantasCompra;
                        valorTotalCompra *= 0.95;
                        System.out.println("Valor total com desconto de 5%: " + valorTotalCompra);
                        registroVenda(qtdPlantasCompra, valorTotalCompra, vendasDiarias, data);
                    } else {
                        double valorTotalCompra = qtdPlantasCompra * valorPlantasCompra;
                        System.out.println("Valor total: " + valorTotalCompra);
                        registroVenda(qtdPlantasCompra, valorTotalCompra, vendasDiarias, data);
                    }
                    contador += 1;
                    break;

                case 4:
                    System.out.println("Digite o mês para a busca (MM): ");
                    String mesBusca = scanner.next();
                    System.out.println("Digite o dia para a busca (DD): ");
                    String diaBusca = scanner.next();
                    String dataBusca = mesBusca + "-" + diaBusca;
                    buscarVendasPorDia(vendasDiarias, dataBusca);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }

    public static void registroVenda(int qtdPlantas, double valorTotal, Map<String, Double> vendasDiarias, String data) {
        if (vendasDiarias.containsKey(data)) {
            vendasDiarias.put(data, vendasDiarias.get(data) + valorTotal);
        } else {
            vendasDiarias.put(data, valorTotal);
        }
    }

    public static void buscarVendasPorDia(Map<String, Double> vendasDiarias, String data) {
        if (vendasDiarias.containsKey(data)) {
            System.out.println("Vendas no dia " + data + ": " + vendasDiarias.get(data));
        } else {
            System.out.println("Nenhuma venda registrada para o dia " + data);
        }
    }
}
