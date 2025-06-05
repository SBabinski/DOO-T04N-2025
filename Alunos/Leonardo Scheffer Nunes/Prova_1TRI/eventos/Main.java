package eventos;

import java.time.LocalDate; // Importação de LocalDate
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos(); // Criação do sistema de eventos
        Scanner sc = new Scanner(System.in); // Leitor de entrada
        int opcao;

        do {
            // Exibe o menu de opções
            System.out.println("\n1. Cadastrar cliente");
            System.out.println("2. Cadastrar show");
            System.out.println("3. Cadastrar congresso");
            System.out.println("4. Listar eventos");
            System.out.println("5. Comprar ingresso");
            System.out.println("6. Utilizar ingresso");
            System.out.println("0. Sair");
            opcao = sc.nextInt(); sc.nextLine(); // Lê a opção escolhida

            switch (opcao) {
                case 1:
                    // Cadastro de cliente
                    System.out.print("Nome: "); 
                    String nome = sc.nextLine();
                    System.out.print("CPF: "); 
                    String cpf = sc.nextLine();
                    sistema.cadastrarCliente(nome, cpf); 
                    break;
                case 2: // Cadastrar show
                case 3: // Cadastrar congresso
                    System.out.print("Nome do evento: "); 
                    String nomeEv = sc.nextLine();
                    System.out.print("Data início (AAAA-MM-DD): "); 
                    LocalDate ini = LocalDate.parse(sc.nextLine());
                    System.out.print("Data fim (AAAA-MM-DD): "); 
                    LocalDate fim = LocalDate.parse(sc.nextLine());
                    System.out.print("Preço diário: "); 
                    double preco = sc.nextDouble();
                    System.out.print("Capacidade: "); 
                    int cap = sc.nextInt(); 
                    sc.nextLine(); // Limpa o buffer
                    if (opcao == 2)
                        sistema.cadastrarShow(nomeEv, ini, fim, preco, cap); // Cadastra show
                    else
                        sistema.cadastrarCongresso(nomeEv, ini, fim, preco, cap); // Cadastra congresso
                    break;
                case 4:
                    sistema.listarEventos(); // Lista eventos cadastrados
                    break;
                case 5:
                    // Comprar ingresso
                    sistema.listarEventos(); // Lista eventos disponíveis
                    System.out.print("Escolha o evento: "); 
                    int idx = sc.nextInt() - 1; // Lê o índice do evento
                    System.out.print("CPF do cliente: "); 
                    sc.nextLine(); // Limpa o buffer
                    String cpfCl = sc.nextLine();
                    System.out.print("VIP (true/false): "); 
                    boolean vip = sc.nextBoolean();
                    sistema.comprarIngresso(idx, cpfCl, vip); 
                    break;
                case 6:
                    // Utilizar ingresso
                    System.out.print("CPF do cliente: "); 
                    String cpfU = sc.nextLine();
                    sistema.utilizarIngresso(cpfU); 
                    break;
            }

        } while (opcao != 0); // Condição para sair

        sc.close(); // Fecha o scanner
    }
}
