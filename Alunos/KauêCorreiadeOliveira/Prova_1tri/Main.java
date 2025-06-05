import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean executando = true;

        while (executando) {
            System.out.println("\nmenu wow");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar evento");
            System.out.println("3. Listar eventos");
            System.out.println("4. Comprar ingresso");
            System.out.println("5. Usar ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    sistema.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Tipo (show ou congresso): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Data início (dia/mes/ano): ");
                    LocalDate inicio = LocalDate.parse(scanner.nextLine(), formato);

                    System.out.print("Data fim (dia/mes/ano): ");
                    LocalDate fim = LocalDate.parse(scanner.nextLine(), formato);

                    System.out.print("Valor diário: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Capacidade máxima: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();

                    Evento evento = new Evento(nomeEvento, tipo, inicio, fim, valor, capacidade);
                    sistema.adicionarEvento(evento);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;

                case 3:
                    for (Evento e : sistema.eventos) {
                        System.out.println("Evento: " + e.nome +
                            "  Tipo: " + e.tipo +
                            "  Dias: " + e.getDuracaoDias() +
                            "  Ingressos vendidos: " + e.ingressos.size() +
                            "  Vagas disponíveis: " + (e.capacidadeMaxima - e.ingressos.size()));
                    }
                    break;

                case 4:
                    System.out.print("CPF do cliente: ");
                    String cpfIngresso = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoNome = scanner.nextLine();

                    Evento ev = sistema.buscarEvento(eventoNome);
                    if (ev == null) {
                        System.out.println("Evento não encontrado.");
                        break;
                    }

                    boolean vip = false;
                    if (ev.tipo.equals("show")) {
                        System.out.print("Deseja ingresso VIP? (s/n): ");
                        vip = scanner.nextLine().equalsIgnoreCase("s");
                    }

                    boolean comprado = sistema.comprarIngresso(eventoNome, cpfIngresso, vip);
                    if (comprado) {
                        System.out.println("Ingresso comprado com sucesso!");
                        System.out.println("Valor: R$ " + ev.calcularValorIngresso(vip));
                    } else {
                        System.out.println("Não foi possível comprar o ingresso (sem vagas ou VIP indisponível).");
                    }
                    break;

                case 5:
                    System.out.print("CPF do cliente: ");
                    String cpfUsar = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String nomeEv = scanner.nextLine();

                    boolean usado = sistema.usarIngresso(nomeEv, cpfUsar);
                    if (usado) {
                        System.out.println("Ingresso utilizado com sucesso!");
                    } else {
                        System.out.println("Ingresso não encontrado ou já usado.");
                    }
                    break;

                case 0:
                    executando = false;
                    System.out.println("Sistema encerrado. Até mais, Cleitinho!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
