package gabrielinha;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Loja> lojas = new ArrayList<>();

    public static void main(String[] args) {
 
        boolean menu = true;
        while (menu) {
            System.out.println("O que deseja fazer?\n1 - Cadastrar Loja\n2 - Cadastrar Vendedor\n3 - Cadastrar Cliente\n4 - Exibir Lojas\n5 - Exibir Vendedores\n6 - Exibir Clientes\n7 - Sair");
            int escolha = scan.nextInt();
            scan.nextLine(); // Consumir quebra de linha

            switch (escolha) {
                case 1:
                    cadastrarLoja();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    cadastrarCliente();
                    break;
                case 4:
                    listarLojas();
                    break;
                case 5:
                    listarVendedores();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    menu = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarLoja(){
        Loja loja = new Loja();
        System.out.println("Insira o nome fantasia da loja:");
        loja.nomeFantasia = scan.nextLine();
        System.out.println("Insira a razão social:");
        loja.razaoSocial = scan.nextLine();
        System.out.println("Insira o ID da loja:");
        loja.id = scan.nextInt();
        scan.nextLine();
        System.out.println("Insira o CNPJ:");
        loja.cnpj = scan.nextLine();
        System.out.println("Insira a cidade:");
        loja.cidade = scan.nextLine();
        System.out.println("Insira o bairro:");
        loja.bairro = scan.nextLine();
        System.out.println("Insira a rua:");
        loja.rua = scan.nextLine();

        lojas.add(loja);
        System.out.println("Loja cadastrada com sucesso!\n");
    }

    public static void cadastrarVendedor(){
        System.out.println("Insira o ID da loja onde o vendedor trabalha:");
        int idLoja = scan.nextInt();
        scan.nextLine();

        // Busca a loja pelo ID
        Loja lojaEncontrada = null;
        for (Loja l : lojas) {
            if (l.id == idLoja) {
                lojaEncontrada = l;
                break;
            }
        }

        if (lojaEncontrada == null) {
            System.out.println("Loja não encontrada! Cadastre a loja antes de adicionar um vendedor.");
            return;
        }
        
        Vendedor vendedor = new Vendedor();
        System.out.println("Insira o nome do vendedor:");
        vendedor.nome = scan.nextLine();
        System.out.println("Insira a idade:");
        vendedor.idade = scan.nextInt();
        System.out.println("Insira o salário base:");
        vendedor.salarioBase = scan.nextDouble();
        scan.nextLine();
        System.out.println("Insira a cidade:");
        vendedor.cidade = scan.nextLine();
        System.out.println("Insira o bairro:");
        vendedor.bairro = scan.nextLine();
        System.out.println("Insira a rua:");
        vendedor.rua = scan.nextLine();

        System.out.println("Insira os três últimos salários recebidos:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Salário " + (i + 1) + ": ");
            vendedor.salariosRecebidos[i] = scan.nextDouble();
        }
        scan.nextLine();
        
        lojaEncontrada.adicionarVendedor(vendedor);
        System.out.println("Vendedor cadastrado na loja " + lojaEncontrada.nomeFantasia + " com sucesso!\n");
    }

    public static void cadastrarCliente(){
        Cliente cliente = new Cliente();
        System.out.println("Insira o nome do cliente:");
        cliente.nome = scan.nextLine();
        System.out.println("Insira a idade:");
        cliente.idade = scan.nextInt();
        scan.nextLine();
        System.out.println("Insira a cidade:");
        cliente.cidade = scan.nextLine();
        System.out.println("Insira o bairro:");
        cliente.bairro = scan.nextLine();
        System.out.println("Insira a rua:");
        cliente.rua = scan.nextLine();

        if (!lojas.isEmpty()) {
            System.out.println("Insira o ID da loja onde o cliente será cadastrado:");
            int idLoja = scan.nextInt();
            scan.nextLine();

            Loja lojaEncontrada = null;
            for (Loja l : lojas) {
                if (l.id == idLoja) {
                    lojaEncontrada = l;
                    break;
                }
            }

            if (lojaEncontrada != null) {
                lojaEncontrada.adicionarCliente(cliente);
                System.out.println("Cliente cadastrado na loja " + lojaEncontrada.nomeFantasia + " com sucesso!\n");
            } else {
                System.out.println("Loja não encontrada! Cadastre a loja antes de adicionar um cliente.");
            }
        } else {
            System.out.println("Nenhuma loja cadastrada! Cadastre uma loja primeiro.");
        }
    }

    public static void listarLojas() {
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada.");
        } else {
            System.out.println("Lista de Lojas:");
            for (Loja l : lojas) {
                l.apresentarse();
                System.out.println("-----------------------------------");
            }
        }
    }

    public static void listarVendedores() {
        System.out.println("Lista de Vendedores:");
        for (Loja l : lojas) {
            for (int i = 0; i < l.totalVendedores; i++) {
                l.vendedores[i].apresentarse();
                System.out.println("Média salarial: " + l.vendedores[i].calcularMedia());
                System.out.println("Bônus salarial: " + l.vendedores[i].calcularBonus());
                System.out.println("Loja: " + l.nomeFantasia);
                System.out.println("-----------------------------------");
            }
        }
    }

    public static void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Loja l : lojas) {
            for (int i = 0; i < l.totalClientes; i++) {
                l.clientes[i].apresentarse();
                System.out.println("Loja: " + l.nomeFantasia);
                System.out.println("-----------------------------------");
            }
        }
    }

}
