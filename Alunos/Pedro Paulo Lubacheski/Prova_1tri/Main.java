
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Show> shows = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().iniciar();  //tava dando erro e não sabia o que era
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarShow();
                    break;
                case 3:
                    listarShows();
                    break;
                case 4:
                    venderIngresso();
                    break;
                case 5:
                    utilizarIngresso();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 6);
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar show");
        System.out.println("3. Listar shows");
        System.out.println("4. Vender ingresso");
        System.out.println("5. Utilizar ingresso");
        System.out.println("6. Sair");
        System.out.print("Escolha: ");
    }

    private void cadastrarCliente() {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado!");
    }

    private void cadastrarShow() {
        System.out.print("\nNome do show: ");
        String nome = scanner.nextLine();
        System.out.print("Duração (dias): ");
        int dias = scanner.nextInt();
        System.out.print("Valor diário normal: ");
        double valorDiario = scanner.nextDouble();
        System.out.print("Valor adicional VIP: ");
        double valorVip = scanner.nextDouble();
        System.out.print("Capacidade total: ");
        int capacidade = scanner.nextInt();

        shows.add(new Show(nome, dias, valorDiario, valorVip, capacidade));
        System.out.println("Show cadastrado!");
    }

    private void listarShows() {
        if (shows.isEmpty()) {
            System.out.println("\nNenhum show cadastrado!");
            return;
        }

        System.out.println("\n=== SHOWS ===");
        for (Show show : shows) {
            System.out.println(show);
            System.out.println("Vagas disponíveis: " + show.getVagasDisponiveis());
            System.out.println("----------------");
        }
    }

    private void venderIngresso() {
        if (clientes.isEmpty() || shows.isEmpty()) {
            System.out.println("\nCadastre clientes e shows primeiro!");
            return;
        }

        System.out.println("\nClientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ". " + clientes.get(i));
        }
        System.out.print("Escolha o cliente: ");
        int clienteIdx = scanner.nextInt();

        System.out.println("\nShows:");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println(i + ". " + shows.get(i).getNome());
        }
        System.out.print("Escolha o show: ");
        int showIdx = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Deseja ingresso VIP? (s/n): ");
        boolean vip = scanner.nextLine().equalsIgnoreCase("s");

        Show show = shows.get(showIdx);
        double valor = show.calcularValor(vip);

        System.out.printf("\nValor total: R$%.2f%n", valor);
        System.out.print("Confirmar compra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            if (show.venderIngresso(clientes.get(clienteIdx), vip)) {
                System.out.println("Ingresso vendido com sucesso!");
            } else {
                System.out.println("Não há vagas disponíveis!");
            }
        }
    }

    private void utilizarIngresso() {
        if (shows.isEmpty()) {
            System.out.println("\nNenhum show cadastrado!");
            return;
        }

        System.out.println("\nShows:");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println(i + ". " + shows.get(i).getNome());
        }
        System.out.print("Escolha o show: ");
        int showIdx = scanner.nextInt();

        Show show = shows.get(showIdx);
        List<Ingresso> ingressos = show.getIngressos();

        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso vendido para este show!");
            return;
        }

        System.out.println("\nIngressos:");
        for (int i = 0; i < ingressos.size(); i++) {
            Ingresso ingresso = ingressos.get(i);
            System.out.println(i + ". " + ingresso.getCliente().getNome()
                    + (ingresso.isVip() ? " (VIP)" : "")
                    + (ingresso.isUtilizado() ? " [USADO]" : ""));
        }

        System.out.print("Escolha o ingresso: ");
        int ingressoIdx = scanner.nextInt();
        scanner.nextLine();

        Ingresso ingresso = ingressos.get(ingressoIdx);
        if (ingresso.isUtilizado()) {
            System.out.println("Este ingresso já foi utilizado!");
        } else {
            ingresso.utilizar();
            System.out.println("Ingresso utilizado com sucesso!");
        }
    }
}
