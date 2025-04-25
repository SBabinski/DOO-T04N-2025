import java.util.Scanner;
import java.util.ArrayList;

public class Funcoes {
    public Scanner scan = new Scanner(System.in);
    int idLoja = 0;
    ArrayList <Cliente> listaDeClientes = new ArrayList<>();
    ArrayList <Vendedor> listaDeVendedores = new ArrayList<>();
    ArrayList <Gerente> listaDeGerentes = new ArrayList<>();
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

        Endereco endereco = digitarEndereco();
        Loja loja = new Loja(idLoja, nomeFantasia, razaoSocial, cnpj, endereco);
        listaDeLojas.add(loja);
    }

    public void adicionarGerenteLoja() {
        System.out.println("Insira o nome");
        String nome = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira idade");
        int idade = scan.nextInt();
        scan.nextLine(); // limpar teclado

        exibirNomeIdLojas();
        System.out.println("Insira o id da loja dele");
        int idLojaGerente = scan.nextInt();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira salario base");
        double salarioBase = scan.nextDouble();
        scan.nextLine(); // limpar teclado

        Endereco endereco = digitarEndereco();

        Loja lojaGerente = null;
        for (Loja loja : listaDeLojas) {
            if (loja.getIdLoja() == idLojaGerente) {
                lojaGerente = loja;
                break;
            }
        }

        double salarioRecebido[] = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("insira o " + (i+1) + "° salario: ");
            salarioRecebido[i] = scan.nextDouble();
        }

        Gerente gerente = new Gerente(idLojaGerente, nome, idade, lojaGerente, endereco, salarioBase, salarioRecebido);
        listaDeGerentes.add(gerente);

        if (!lojaGerente.getListaDeGerentesLoja().contains(gerente)) { 
            lojaGerente.getListaDeGerentesLoja().add(gerente);
        }
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

        System.out.println("Insira salario base");
        double salarioBase = scan.nextDouble();
        scan.nextLine(); // limpar teclado

        Endereco endereco = digitarEndereco();

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

        Vendedor vendedor = new Vendedor(idLojaVendedor, nome, idade, lojaVendedor, endereco, salarioBase, salarioRecebido);
        listaDeVendedores.add(vendedor);

        if (!lojaVendedor.getListaDeVendedoresLoja().contains(vendedor)) { 
            lojaVendedor.getListaDeVendedoresLoja().add(vendedor);
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

        Endereco endereco = digitarEndereco();

        Loja lojaCliente = null;
        for (Loja loja : listaDeLojas) {
            if (loja.getIdLoja() == idLojaCliente) {
                lojaCliente = loja;
                break;
            }
        }

        Cliente cliente = new Cliente(idLojaCliente, nome, idade, lojaCliente, endereco);
        listaDeClientes.add(cliente);

        if (!lojaCliente.getListaDeClientesLoja().contains(cliente)) { 
            lojaCliente.getListaDeClientesLoja().add(cliente);
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

    public void analisarGerentes() {
        for (Loja loja : listaDeLojas) {
            loja.contarGerentes();
            loja.getListaDeGerentesLoja();
        }
    }


    public void analisarVendedores() {
        for (Loja loja : listaDeLojas) {
            loja.contarVendedores();
            loja.getListaDeVendedoresLoja();
        }
    }

    public void analisarClientes() {
        for (Loja loja : listaDeLojas) {
            loja.contarClientes();
            loja.getListaDeClientesLoja();
        }
    }

    public void salariosBonusGerente() {
        for (Gerente gerente : listaDeGerentes) {
            System.out.println("O gerente " + gerente.getNome() + " da loja " + gerente.getLoja().getNomeFantasia() + " tem um salario medio de " + gerente.calcularMedia() + " e um bonus de " + gerente.calcularBonus());
        }
    }

    public void salariosBonusVendedor() {
        for (Vendedor vendedor : listaDeVendedores) {
            System.out.println("O vendedor " + vendedor.getNome() + " da loja " + vendedor.getLoja().getNomeFantasia() + " tem um salario medio de " + vendedor.calcularMedia() + " e um bonus de " + vendedor.calcularBonus());
        }
    }

    public Endereco digitarEndereco() {
        System.out.println("Insira estado");
        String estado = scan.next();
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

        System.out.println("Insira numero");
        String numero = scan.next();
        scan.nextLine(); // limpar teclado

        System.out.println("Insira complemento");
        String complemeto = scan.next();
        scan.nextLine(); // limpar teclado

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero, complemeto);
        return endereco;

    }
}