package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Clientes;
import entities.Loja;
import entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Vendedor> vendedores = new ArrayList<>();
		ArrayList<Clientes> clientes = new ArrayList<>();
		Loja loja = new Loja();
		
		int op;
		do {
			System.out.println("\n===== Menu =====");
            System.out.println("[1] - Adicionar funcionário");
            System.out.println("[2] - Adicionar cliente");
            System.out.println("[3] - Exibir lista de funcionários");
            System.out.println("[4] - Exibir lista de clientes");
            System.out.println("[5] - sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            
            switch (op) {
            	case 1:
            		adicionarFuncionario(sc, vendedores);
            		loja.adicionarFuncionario(vendedores.get(vendedores.size() - 1));
            		break;
            	case 2:
            		adicionarClientes(sc, clientes);
            		loja.adicionarClientes(clientes.get(clientes.size() - 1));
            		break;
            	case 3:
            		loja.listarFuncionarios();
            		break;
            	case 4:
            		loja.listarClientes();
            		break;
            	case 5:
            		System.out.println("Saindo...");
            		break;
            	default:
            		System.out.println("Escolha uma opção válida");
            		
            		
            }
		}while(op != 5);
		
		
		
		sc.close();

	}
	
	public static void adicionarFuncionario(Scanner sc, ArrayList<Vendedor> vendedor) {
		sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Loja: ");
		String loja = sc.nextLine();
		
		System.out.print("Cidade: ");
		String cidade = sc.nextLine();
		
		System.out.print("Bairro: ");
		String bairro = sc.nextLine();
		
		System.out.print("Rua: ");
		String rua = sc.nextLine();
		
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		
		System.out.println("Salários recebidos: ");
		int n = sc.nextInt();
		
		ArrayList<Double> salarioRecebido = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			System.out.println("Salário: " + (i+1) + ": ");
			double salario = sc.nextDouble();
			salarioRecebido.add(salario);
		}
		
		Vendedor novo = new Vendedor(nome, idade, loja, cidade, bairro, rua, salarioBase, salarioRecebido);
		vendedor.add(novo);
	}
	
	public static void adicionarClientes(Scanner sc, ArrayList<Clientes> cliente) {
		sc.nextLine();
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
		
		Clientes novo = new Clientes(nome, idade, cidade, bairro, rua);
		cliente.add(novo);
	}

}
