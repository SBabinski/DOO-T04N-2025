package prova;

import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
           System.out.println("Prova samuel");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Show");
            System.out.println("3. Cadastrar Congresso");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Comprar Ingresso");
            System.out.println("6. Utilizar Ingresso");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    sistema.cadastrarCliente(nome, cpf);
                    break;
                case 2:
                    System.out.print("Nome do show: ");
                    String nomeShow = scanner.nextLine();
                    System.out.print("Dias: ");
                    int diasS = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoS = scanner.nextDouble();
                    System.out.print("Capacidade: ");
                    int capS = scanner.nextInt();
                    scanner.nextLine();
                    sistema.cadastrarShow(nomeShow, diasS, precoS, capS);
                    break;
                case 3:
                    System.out.print("Nome do congresso: ");
                    String nomeCong = scanner.nextLine();
                    System.out.print("Dias: ");
                    int diasC = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoC = scanner.nextDouble();
                    System.out.print("Capacidade: ");
                    int capC = scanner.nextInt();
                    scanner.nextLine();
                    sistema.cadastrarCongresso(nomeCong, diasC, precoC, capC);
                    break; 
                case 4:
                    sistema.listarEventos(); 
                    break;
                case 5:
                    System.out.print("CPF do cliente: ");
                    String cpfCompra = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoCompra = scanner.nextLine();
                    System.out.print("VIP? (true/false): ");
                    boolean vip = scanner.nextBoolean();
                    scanner.nextLine();
                    sistema.comprarIngresso(cpfCompra, eventoCompra, vip);
                    break;
                    
                case 6:
                    System.out.print("CPF do cliente: ");
                    String cpfUsa = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoUsa = scanner.nextLine();
                    sistema.utilizarIngresso(cpfUsa, eventoUsa); 
                    break;
                    
                    
                
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}