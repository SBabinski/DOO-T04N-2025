// Principal.java
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sp = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n1. Cadastrar cliente\n2. Cadastrar evento\n3. Listar eventos\n4. Comprar ingresso\n5. Usar ingresso\n6. Listar ingressos\n0. Sair");
            opcao = sp.nextInt();
            sp.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sp.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sp.nextLine();
                    sistema.cadastrarCliente(nome, cpf);
                }
                case 2 -> {
                    System.out.print("Tipo (congresso/show): ");
                    String tipo = sp.nextLine();
                    System.out.print("Nome do evento: ");
                    String nome = sp.nextLine();
                    System.out.print("Duração (dias): ");
                    int dias = sp.nextInt();
                    System.out.print("Valor diário: ");
                    double valor = sp.nextDouble();
                    System.out.print("Capacidade: ");
                    int capacidade = sp.nextInt();
                    sp.nextLine();
                    sistema.cadastrarEvento(tipo, nome, dias, valor, capacidade);
                }
                case 3 -> sistema.listarEventos();
                case 4 -> {
                    sistema.listarEventos();
                    System.out.print("Escolha o Numero do evento: ");
                    int eIdx = sp.nextInt();
                    System.out.print("Cliente (CPF): ");
                    int cIdx = sp.nextInt();
                    System.out.print("VIP? (Sim(1) /Não(2)): ");
                    boolean vip = sp.nextBoolean();
                    sistema.comprarIngresso(cIdx, eIdx, vip);
                }
                case 5 -> {
                    sistema.listarIngressos();
                    System.out.print("Escolha o ingresso: ");
                    int idx = sp.nextInt();
                    sistema.usarIngresso(idx);
                }
                case 6 -> sistema.listarIngressos();
                case 0 -> System.out.println("Encerrando Sistema...");
                default -> System.out.println("Opção inválida.");
            }
        }

        sp.close();
    }
}
