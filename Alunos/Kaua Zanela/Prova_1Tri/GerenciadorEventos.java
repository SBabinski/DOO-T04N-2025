package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorEventos {
    private List<Evento> eventos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();

    public void cadastrarCliente(String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome() + " - " + cliente.getEmail());
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento cadastrado: " + evento.getNome());
    }

    public void listarEventos() {
        System.out.println("Eventos disponíveis:");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println((i + 1) + ". " + evento.getNome() + " - Ingresso Normal: R$" + evento.calcularValorIngresso(false)
                    + " | Ingresso VIP: R$" + evento.calcularValorIngresso(true));
        }
    }

    public void comprarIngresso() {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite seu e-mail: ");
        String emailCliente = scanner.nextLine();
        cadastrarCliente(nomeCliente, emailCliente);

        Cliente cliente = buscarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        
        listarEventos();
        System.out.print("Escolha o número do evento para o qual deseja comprar ingresso: ");
        int eventoEscolhido = scanner.nextInt();
        Evento evento = buscarEventoPorIndice(eventoEscolhido - 1);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

     
        System.out.println("\nEvento escolhido: " + evento.getNome());
        System.out.println("Preço ingresso normal: R$ " + evento.calcularValorIngresso(false));
        System.out.println("Preço ingresso VIP: R$ " + evento.calcularValorIngresso(true));

        System.out.print("Escolha o tipo de ingresso (1 - Normal | 2 - VIP): ");
        int tipoIngresso = scanner.nextInt();
        boolean vip = tipoIngresso == 2;

        
        if (!evento.verificarDisponibilidade()) {
            System.out.println("Desculpe, não há vagas disponíveis para esse evento.");
            return;
        }

        if (evento instanceof Show && vip && !((Show) evento).adicionarParticipanteVIP()) {
            System.out.println("Desculpe, não há mais vagas VIP disponíveis.");
            return;
        }

        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        ingressos.add(ingresso);
        evento.reservarVaga(vip);
        System.out.println("Ingresso comprado com sucesso!");
        ingresso.apresentarIngresso();
    }

    private Cliente buscarClientePorNome(String nome) {
        return clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    private Evento buscarEventoPorIndice(int indice) {
        if (indice >= 0 && indice < eventos.size()) {
            return eventos.get(indice);
        }
        return null;
    }
}
