package system;

import java.util.ArrayList;
import java.util.Scanner;
import entities.Cliente;
import entities.Congresso;
import entities.Evento;
import entities.Show;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Evento> eventos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== SISTEMA DE EVENTOS ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarCliente(clientes, scanner);
                    break;
                    
                case 2:
                    cadastrarEvento(eventos, scanner);
                    break;
                    
                case 3:
                    listarEventos(eventos);
                    break;
                    
                case 4:
                    comprarIngresso(clientes, eventos, scanner);
                    break;
                    
                case 5:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void cadastrarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        clientes.add(new Cliente(nome, email));
        System.out.println("Cliente cadastrado com sucesso!");
    }
    
    private static void cadastrarEvento(ArrayList<Evento> eventos, Scanner scanner) {
        System.out.print("\nNome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Duração (dias): ");
        int dias = scanner.nextInt();
        System.out.print("Preço diário: R$");
        double preco = scanner.nextDouble();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        System.out.print("Tipo (1-Show, 2-Congresso): ");
        int tipo = scanner.nextInt();
        
        if (tipo == 1) {
            System.out.print("Adicional VIP/dia: R$");
            double adicional = scanner.nextDouble();
            eventos.add(new Show(nome, dias, preco, capacidade, adicional));
        } else if (tipo == 2) {
            eventos.add(new Congresso(nome, dias, preco, capacidade));
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        System.out.println("Evento cadastrado com sucesso!");
    }
    
    private static void listarEventos(ArrayList<Evento> eventos) {
        System.out.println("\nEVENTOS DISPONÍVEIS:");
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            for (int i = 0; i < eventos.size(); i++) {
                System.out.println((i+1) + ". " + eventos.get(i));
            }
        }
    }
    
    private static void comprarIngresso(ArrayList<Cliente> clientes, ArrayList<Evento> eventos, Scanner scanner) {
        if (clientes.isEmpty() || eventos.isEmpty()) {
            System.out.println("\nCadastre clientes e eventos primeiro!");
            return;
        }
        
        System.out.println("\nCLIENTES:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i+1) + ". " + clientes.get(i));
        }
        System.out.print("Escolha o cliente: ");
        int clienteIdx = scanner.nextInt() - 1;
        
        System.out.println("\nEVENTOS:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i+1) + ". " + eventos.get(i));
        }
        System.out.print("Escolha o evento: ");
        int eventoIdx = scanner.nextInt() - 1;
        
        if (clienteIdx < 0 || clienteIdx >= clientes.size() || 
            eventoIdx < 0 || eventoIdx >= eventos.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        
        Evento evento = eventos.get(eventoIdx);
        Cliente cliente = clientes.get(clienteIdx);
        boolean vip = false;
        
        if (evento instanceof Show) {
            System.out.print("Deseja ingresso VIP? (s/n): ");
            vip = scanner.next().equalsIgnoreCase("s");
        }
        
        boolean sucesso;
        if (evento instanceof Show && vip) {
            sucesso = ((Show)evento).addParticipanteVip(cliente);
        } else {
            sucesso = evento.addParticipante(cliente);
        }
        
        if (sucesso) {
            System.out.printf("%nIngresso %scomprado! Valor: R$%.2f%n",
                            vip ? "VIP " : "", evento.calcularValor(vip));
        } else {
            System.out.println("\nNão foi possível comprar. Vagas esgotadas!");
        }
    }
}