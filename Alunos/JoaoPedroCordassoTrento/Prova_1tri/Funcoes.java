import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Evento> listaDeEventos = new ArrayList<>();
    public int idEvento = 0;
    public ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    public int idCliente = 0;

    public void cadastrarEvento() {
        idEvento++;

        System.out.println("Nome do Evento: ");
        String nomeEvento = scan.next();

        System.out.println("Quantidade de Ingressos: ");
        int qtdIngressos = scan.nextInt();

        System.out.println("Valor do Ingresso: ");
        double valorIngresso = scan.nextDouble();

        System.out.println("Dias de Duração: ");
        int diasDuracao = scan.nextInt();

        System.out.println("[1] show \n[2] congresso \nQual o Tipo do Evento: ");
        int escEvento = scan.nextInt();
        String tipoEvento = null;

        if(escEvento == 1) {
            tipoEvento = "show";
        } else if(escEvento == 2) {
            tipoEvento = "congresso";
        }

        Evento evento = new Evento(idEvento, nomeEvento, qtdIngressos, valorIngresso, diasDuracao, tipoEvento);
        listaDeEventos.add(evento);
    }

    public void exibirNomeIdIngressosDisponiveisEvento() {
        for (Evento evento : listaDeEventos) {
            System.out.println("Nome: " + evento.getNomeEvento() + " ID: " + evento.getIdEvento() + 
                                        " Ingressos: " + evento.mostrarIgressosDisponiveis() +
                                        " Ingressos VIPs: " + evento.mostrarIgressosVIPDisponiveis());
        }
    }

    public void cadastrarCliente() {
        idCliente++;

        System.out.println("Nome do Cliente: ");
        String nomeCliente = scan.next();

        System.out.println("Idade do Cliente: ");
        int idade = scan.nextInt();

        Cliente cliente = new Cliente(idCliente, nomeCliente, idade);
        listaDeClientes.add(cliente);
    }

    public void exibirNomeIdCliente() {
        for (Cliente cliente : listaDeClientes) {
            System.out.println("Nome: " + cliente.getNome() + " : " + cliente.getIdCliente());
        }
    }

    public void comprarIngresso() {
        exibirNomeIdCliente();
        System.out.println("Insira o ID do cliente que deseja comprar um ingresso: ");
        int idDoCliente = scan.nextInt();
    
        exibirNomeIdIngressosDisponiveisEvento();
        System.out.println("Insira o ID do evento: ");
        int idDoEvento = scan.nextInt();
    
        for (Evento evento : listaDeEventos) {
            if (evento.getIdEvento() == idDoEvento) {
                System.out.println("[1] Normal \n[2] VIP");
                System.out.println("Qual tipo de ingresso você quer?");
                System.out.println("Valor Ingresso: R$" + evento.getValorIngresso());
                System.out.println("Valor Ingresso VIP: R$" + evento.getValorIngressoVIP());
    
                int tipoIngresso = scan.nextInt();
                int ingressosComprados;
    
                System.out.println("Quantos ingressos você deseja comprar?");
                ingressosComprados = scan.nextInt();
    
                if (ingressosComprados > evento.getDiasDuracao()) {
                    System.out.println("Quantidade inválida");
                    break;
                }
    
                boolean compraValida = false;
    
                if (tipoIngresso == 1) {
                    if (ingressosComprados <= evento.mostrarIgressosDisponiveis()) {
                        evento.setQtdIngressosVendidos(evento.getQtdIngressosVendidos() + ingressosComprados);
                        compraValida = true;
                    } else {
                        System.out.println("ingressos normais insuficientes");
                    }
                } else if (tipoIngresso == 2) {
                    if (ingressosComprados <= evento.mostrarIgressosVIPDisponiveis()) {
                        evento.setQtdIngressosVendidosVIP(evento.getQtdIngressosVendidosVIP() + ingressosComprados);
                        compraValida = true;
                    } else {
                        System.out.println("ingressos VIP insuficientes");
                    }
                } else {
                    System.out.println("opção invalida.");
                }
    
                if (compraValida) {
                    for (Cliente cliente : listaDeClientes) {
                        if (cliente.getIdCliente() == idDoCliente) {
                            cliente.getListaDeEventosCliente().add(evento);
                            System.out.println("Compra feita");
                            break;
                        }
                    }
                }
    
                break; 
            }
        }
    }
    

    public void exibirEventos() {
        for (Evento evento : listaDeEventos) {
            System.out.println(evento);
        }
    }

    public void exibirClientes() {
        for (Cliente cliente : listaDeClientes) {
            System.out.println(cliente);
        }
    }
}
