package dedeae;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Loja myPlant = new Loja(
        "My Plant",
        "My Plant Comércio de Plantas LTDA",
        "12.345.678/0001-90",
        "Floripa",
        "Centro",
        "Rua das Palmeiras"
    );

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Vendedor");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Mostrar Vendedores");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Dados da Loja");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarVendedor();
                case 2 -> cadastrarCliente();
                case 3 -> mostrarVendedores();
                case 4 -> mostrarClientes();
                case 5 -> myPlant.apresentarse();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void cadastrarVendedor() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();

        double[] salarios = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Salário recebido #" + (i + 1) + ": ");
            salarios[i] = sc.nextDouble();
        }

        Vendedor vendedor = new Vendedor(nome, idade, myPlant.nomeFantasia, cidade, bairro, rua, salarioBase, salarios);
        myPlant.vendedores.add(vendedor);
        System.out.println("Vendedor cadastrado com sucesso.");
    }

    static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Rua: ");
        String rua = sc.nextLine();

        Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
        myPlant.clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    static void mostrarVendedores() {
        if (myPlant.vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }

        for (Vendedor v : myPlant.vendedores) {
            v.apresentarse();
            System.out.println("Média: R$" + v.calcularMedia());
            System.out.println("Bônus: R$" + v.calcularBonus());
            System.out.println("---");
        }
    }

    static void mostrarClientes() {
        if (myPlant.clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente c : myPlant.clientes) {
            c.apresentarse();
        }
    }
}
