import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        
        int x;
        int quantidade = 0;
        double preco = 0.0; 
        double pagamento = 0, dinheiroCliente, troco;
        
        while (true) {
            System.out.printf("[1] - Calcular Preço Total\n[2] - Calcular Troco\n[3] - Registro de Vendas\n[4] - Consultar Vendas por Mês\n[5] - Consultar Vendas por Dia\n[6] - Sair\n");
            x = sc.nextInt();
            
            if (x == 1) {
                System.out.printf("Qual a quantidade de plantas que o cliente irá comprar?\n");
                quantidade = sc.nextInt();
                System.out.printf("Qual o preço da planta?\n");
                preco = sc.nextDouble();
                if (quantidade >= 10){
                    pagamento = (quantidade * preco) * 0.95;  // Desconto de 5% para 10 ou mais plantas
                } else {
                    pagamento = quantidade * preco;
                }
                System.out.printf("O valor total da compra é: %.2f reais\n", pagamento);
            }
            
            else if (x == 2) {
                if (pagamento == 0) {
                    System.out.println("Primeiro, calcule o preço total das plantas.");
                } else {
                    System.out.printf("Quantos reais vai dar para o pagamento?\n");
                    dinheiroCliente = sc.nextDouble();
                    if (dinheiroCliente < pagamento) {
                        System.out.printf("Você não tem dinheiro suficiente para realizar o pagamento!\n");
                    } else {
                        troco = dinheiroCliente - pagamento;
                        System.out.printf("O seu troco é de %.2f reais! Muito obrigado!\n", troco);
    
                        System.out.println("Informe o dia da venda (1-31): ");
                        int dia = sc.nextInt();
                        System.out.println("Informe o mês da venda (1-12): ");
                        int mes = sc.nextInt();
                        
                        Venda venda = new Venda(quantidade, preco, pagamento, dia, mes);
                        vendas.add(venda);
                    }
                }
            }
            
            else if (x == 3) {
                System.out.println("Registro de Vendas:");
                if (vendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada ainda.");
                } else {
                    for (Venda venda : vendas) {
                        System.out.println(venda);
                    }
                }
            }
            
            else if (x == 4) {
                
                System.out.println("Informe o mês para consultar as vendas: ");
                int mesConsulta = sc.nextInt();
                int totalVendasMes = 0;
                double totalValorMes = 0;
                
                for (Venda venda : vendas) {
                    if (venda.getMes() == mesConsulta) {
                        totalVendasMes++;
                        totalValorMes += venda.getPagamento();
                    }
                }
                
                System.out.printf("Vendas no mês %d: %d vendas, total de R$ %.2f\n", mesConsulta, totalVendasMes, totalValorMes);
            }
            
            else if (x == 5) {
                
                System.out.println("Informe o dia para consultar as vendas: ");
                int diaConsulta = sc.nextInt();
                int totalVendasDia = 0;
                double totalValorDia = 0;
                
                for (Venda venda : vendas) {
                    if (venda.getDia() == diaConsulta) {
                        totalVendasDia++;
                        totalValorDia += venda.getPagamento();
                    }
                }
                
                System.out.printf("Vendas no dia %d: %d vendas, total de R$ %.2f\n", diaConsulta, totalVendasDia, totalValorDia);
            }
            
            else if (x == 6) {
                System.out.println("Saindo... Até logo! E volte sempre!");
                break;
            }
        }
        
        sc.close();
    }
}

class Venda {
    private int quantidade;
    private double preco;
    private double pagamento;
    private int dia;
    private int mes;

    public Venda(int quantidade, double preco, double pagamento, int dia, int mes) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.pagamento = pagamento;
        this.dia = dia;
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public double getPagamento() {
        return pagamento;
    }

    public String toString() {
        double valorTotal = quantidade * preco;
        return String.format("Dia: %d, Mês: %d, Quantidade: %d, Preço unitário: %.2f, Valor Total: %.2f, Pagamento: %.2f", 
                             dia, mes, quantidade, preco, valorTotal, pagamento);
    }
}
