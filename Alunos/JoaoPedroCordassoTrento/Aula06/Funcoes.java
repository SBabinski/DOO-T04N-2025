package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Funcoes {
    public Scanner scan = new Scanner(System.in);
    int idCliente = 0;
    int idVendedor = 0;
    int idLoja = 0;
    ArrayList <Cliente> listaDeClientes = new ArrayList<>();
    ArrayList <Vendedor> listaDeVendedores = new ArrayList<>();
    ArrayList <Loja> listaDeLojas = new ArrayList<>();

    public void cadastrarLoja() {
        idLoja++;
        
        System.out.println("Insira o nome fantasia");
        String nomeFantasia = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira razao social");
        String razaoSocial = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira cnpj");
        String cnpj = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira cidade");
        String cidade = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira bairro");
        String bairro = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira rua");
        String rua = scan.next();
        scan.nextLine(); // limpar teclado

        Loja loja = new Loja(idLoja, nomeFantasia, razaoSocial, cnpj, cidade, bairro, rua);
        listaDeLojas.add(loja);
    }

    public void adicionarVendedorLoja() {
        System.out.println("Insira o nome");
        String nome = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira idade");
        int idade = scan.nextInt();
        scan.nextLine(); // limpar teclado

        exibirNomeIdLojas();
        System.out.println("Insira o id da loja dele");
        int idLojaVendedor = scan.nextInt();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira cidade");
        String cidade = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira bairro");
        String bairro = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira rua");
        String rua = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira salario base");
        double salarioBase = scan.nextDouble();
        scan.nextLine(); // limpar teclado

        Loja lojaVendedor = null;
        for (Loja loja : listaDeLojas) {
            if (loja.getIdLoja() == idLojaVendedor) {
                lojaVendedor = loja;
                break;
            }
        }

        double salarioRecebido[] = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("insira o " + (i+1) + "° salario: ");
            salarioRecebido[i] = scan.nextDouble();
        }

        Vendedor vendedor = new Vendedor(idLojaVendedor, nome, idade, lojaVendedor, cidade, bairro, rua, salarioBase, salarioRecebido);
        listaDeVendedores.add(vendedor);

        if (!lojaVendedor.getlistaDeVendedoresLoja().contains(vendedor)) { 
            lojaVendedor.getlistaDeVendedoresLoja().add(vendedor);
        }
    }

    public void adicionarClienteLoja() {
        System.out.println("Insira o nome");
        String nome = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira idade");
        int idade = scan.nextInt();
        scan.nextLine(); // limpar teclado

        exibirNomeIdLojas();
        System.out.println("Insira o id da loja dele");
        int idLojaCliente = scan.nextInt();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira cidade");
        String cidade = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira bairro");
        String bairro = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira rua");
        String rua = scan.next();
        scan.nextLine(); // limpar teclado

        Loja lojaCliente = null;
        for (Loja loja : listaDeLojas) {
            if (loja.getIdLoja() == idLojaCliente) {
                lojaCliente = loja;
                break;
            }
        }

        Cliente cliente = new Cliente(idLojaCliente, nome, idade, lojaCliente, cidade, bairro, rua);
        listaDeClientes.add(cliente);

        if (!lojaCliente.getlistaDeClientesLoja().contains(cliente)) { 
            lojaCliente.getlistaDeClientesLoja().add(cliente);
        }
    }

    public void exibirLojas() {
        for (Loja loja : listaDeLojas) {
            System.out.println(loja);
        }
    }

    public void exibirNomeIdLojas() {
        for (Loja loja : listaDeLojas) {
            System.out.println(loja.getIdLoja() + ": " + loja.getNomeFantasia());
        }
    }

    public void analisarVendedores() {
        for (Loja loja : listaDeLojas) {
            loja.contarVendedores();
            loja.getlistaDeVendedoresLoja();
        }
    }

    public void analisarClientes() {
        for (Loja loja : listaDeLojas) {
            loja.contarClientes();
            loja.getlistaDeClientesLoja();
        }
    }

    public void salariosBonus() {
        for (Vendedor vendedor : listaDeVendedores) {
            System.out.println("O " + vendedor.getNome() + " da loja " + vendedor.getLoja().getNomeFantasia() + " tem um salario medio de " + vendedor.calcularMedia() + " e um bonus de " + vendedor.calcularBonus());
        }
    }
}