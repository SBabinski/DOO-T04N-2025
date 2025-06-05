package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static int tipo;
    public static Scanner scan = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();
    static List<Evento> eventos = new ArrayList<>();
    static List<Ingresso> ingressos = new ArrayList<>();
    
    public static void main(String[] args) {
        boolean menu = true;
        while (menu == true) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar evento");
            System.out.println("3 - Comprar ingresso");
            System.out.println("4 - Utilizar ingresso");
            System.out.println("5 - Listar eventos");
            System.out.println("0 - Sair");
    
            int escolha = scan.nextInt();
            scan.nextLine(); // limpar buffer
    
            switch (escolha) {
                case 1: cadastrarCliente(); 
                    break;
                case 2: cadastrarEvento(); 
                    break;
                case 3: comprarIngresso(); 
                    break;
                case 4: utilizarIngresso(); 
                    break;
                case 5: listarEventos(); 
                    break;
                case 0: menu = false; 
                    break;
                default: System.out.println("Opção inválida");
            }
        
        }

    }
    
    public static void cadastrarCliente(){
        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();
        clientes.add(new Cliente(nome));


    }

    public static  void cadastrarEvento(){
        System.out.println("DIgite o nome do evento:");
        String nome = scan.nextLine();
        System.out.println("Digite a duração em dias:");
        int dias = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o preço diário:");
        double preco = scan.nextDouble();
        scan.nextLine();
        System.out.println("Digite a capacidade máxima: ");
        int capacidade = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o tipo (1-Show, 2-Congresso): ");
        tipo = scan.nextInt();
        scan.nextLine();

        if (tipo == 1) {
            eventos.add(new Show(nome, dias, preco, capacidade));
        } else {
            eventos.add(new Congresso(nome, dias, preco, capacidade));
        }
        System.out.println("Evento cadastrado");
            

    }

    public static void comprarIngresso() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
    
        listarEventos();
        System.out.println("Escolha o evento:");
        int eventoEscolhido = scan.nextInt() - 1;
        scan.nextLine();
    
        if (eventoEscolhido < 0 || eventoEscolhido >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }
    
        Evento evento = eventos.get(eventoEscolhido);
    
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i));
        }
    
        System.out.println("Escolha o cliente:");
        int clienteEscolhido = scan.nextInt() - 1;
        scan.nextLine();
    
        if (clienteEscolhido < 0 || clienteEscolhido >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
    
        Cliente cliente = clientes.get(clienteEscolhido);
    
        boolean vip = false;
        if (evento instanceof Show) {
            System.out.print("Ingresso VIP? (s/n): ");
            vip = scan.nextLine().equalsIgnoreCase("s");
        }
    
        if (!evento.Disponibilidade(vip)) {
            System.out.println("Evento lotado!");
            return;
        }
    
        double valor = evento.calcularValorIngresso(vip);
        System.out.println("Valor do ingresso: R$" + valor);
    
        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        ingressos.add(ingresso);
        evento.registrarParticipante(cliente);
    
        System.out.println("Ingresso comprado com sucesso!");
    }
    
    public static void utilizarIngresso(){
        for (int i = 0; i < ingressos.size(); i++) {
            System.out.println((i + 1) + " - " + ingressos.get(i));
        }
        System.out.print("Escolha o ingresso para usar: ");
        int escolherIngresso = (scan.nextInt() - 1);
        ingressos.get(escolherIngresso).usarIngresso();
    }

    public static void listarEventos(){

        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + " - " + eventos.get(i));
        }
    }
}

