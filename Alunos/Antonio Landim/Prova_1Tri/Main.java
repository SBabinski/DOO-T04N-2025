package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Evento;
import entities.Ingresso;
import entities.SistemaEventos;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Usar Ingresso");
            System.out.println("6. Listar Ingressos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        sistema.cadastrarCliente(nome, cpf);
                        System.out.println("Cliente cadastrado.");
                        break;

                    case 2:
                        System.out.print("Nome do Show: ");
                        String nomeShow = sc.nextLine();
                        System.out.print("Data Início (dd/MM/yyyy): ");
                        Date inicioShow = sdf.parse(sc.nextLine());
                        System.out.print("Data Fim (dd/MM/yyyy): ");
                        Date fimShow = sdf.parse(sc.nextLine());
                        System.out.print("Valor diário: ");
                        double valorShow = sc.nextDouble();
                        System.out.print("Capacidade total: ");
                        int capacidadeShow = sc.nextInt();
                        sc.nextLine();
                        sistema.cadastrarShow(nomeShow, inicioShow, fimShow, valorShow, capacidadeShow);
                        System.out.println("Show cadastrado.");
                        break;

                    case 3:
                        List<Evento> eventos = sistema.listarEventos();
                        if (eventos.isEmpty()) {
                            System.out.println("Nenhum evento cadastrado.");
                        } else {
                            for (Evento e : eventos) {
                                System.out.println(e);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("CPF do cliente: ");
                        String cpfIngresso = sc.nextLine();
                        System.out.print("Nome do evento: ");
                        String nomeEvento = sc.nextLine();
                        System.out.print("Ingresso VIP? (s/n): ");
                        boolean vip = sc.nextLine().equalsIgnoreCase("s");
                        Date hoje = new Date();
                        boolean comprado = sistema.comprarIngresso(cpfIngresso, nomeEvento, vip, hoje);
                        System.out.println(comprado ? "Ingresso comprado com sucesso." : "Erro na compra do ingresso.");
                        break;

                    case 5:
                        System.out.print("CPF do cliente: ");
                        String cpfUso = sc.nextLine();
                        System.out.print("Nome do evento: ");
                        String eventoUso = sc.nextLine();
                        boolean usado = sistema.usarIngresso(cpfUso, eventoUso);
                        System.out.println(usado ? "Ingresso utilizado com sucesso." : "Ingresso não encontrado ou já utilizado.");
                        break;

                    case 6:
                        List<Ingresso> ingressos = sistema.listarIngressos();
                        if (ingressos.isEmpty()) {
                            System.out.println("Nenhum ingresso registrado.");
                        } else {
                            for (Ingresso i : ingressos) {
                                System.out.println(i);
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (ParseException e) {
                System.out.println("Formato de data inválido! Use dd/MM/yyyy.");
            }
        } while (opcao != 0);

        sc.close();
    }
}

