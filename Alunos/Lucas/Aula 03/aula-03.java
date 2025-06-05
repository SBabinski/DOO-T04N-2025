public class aula-03 {
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public static Scanner scan = new Scanner(System.in);
    public static List<String> historicoVendas = new ArrayList<String>();   
    public static void main(String[] args) {
        boolean menu;
        menu = true;
        while(menu) {
            System.out.println("O que deseja fazer?\n"
                    + "|1| Calcular preço total\n"
                    + "|2| Calcular troco\n"
                    + "|3| Histórico de vendas\n"
                    + "|4| Sair\n");
            int escolha = scan.nextInt();
                switch (escolha) {
                    case 1: {
                        calcularPreco();
                        break;
                    }case 2: {
                        calcularTroco();
                        break;
                    }case 3:{
                        consultarHistorico();
                        break;
                    }case 4: {
                        System.out.println("Saindo...\n");
                        menu = false;
                        break;
                    }
                    default:
                        System.out.println("Escolha inválida\n");
                        break;
                }
        }
    }
    public static void calcularPreco() {
        System.out.println("Calculadora de preço total\n");
        System.out.print("Insira a quantidade de plantas compradas: ");
        int quantidade = scan.nextInt();
        System.out.print("Insira o valor das plantas compradas: ");
        float valorPlanta = scan.nextFloat();
        float valorTotal = (quantidade * valorPlanta);
        float desconto = 0;
        if (quantidade > 10) {
            desconto = valorTotal * (float) 0.05;
            valorTotal = valorTotal - desconto;
        }
        System.out.printf("O valor total é: R$%.2f\n\n",(valorTotal));
        String venda = "Quantidade : " +quantidade+ " | Total: R$"+String.format("%.2f", valorTotal)+
                        " | Desconto: R$"+String.format("%.2f\n", desconto);
        historicoVendas.add(venda);
    }
    public static void calcularTroco() {
        System.out.print("Insira o valor recebido pelo cliente: ");
        float valorPago = scan.nextFloat();
        System.out.print("Insira o valor total da planta: ");
        float valorTotal = scan.nextFloat();
        float troco = (valorPago - valorTotal);
        System.out.printf("O valor do troco é: R$ %.2f\n\n",troco);
    }
    public static void consultarHistorico() {
        if(historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        }else {
            for (String venda : historicoVendas) {
                System.out.println(venda);
                System.out.println();
            }
        }
    }
}
  }
}