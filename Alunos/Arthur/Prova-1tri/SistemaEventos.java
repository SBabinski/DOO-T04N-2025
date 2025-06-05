import java.util.ArrayList;
import java.util.List;

public class SistemaEventos {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    public void cadastrarCliente(String nome, String email) {
        clientes.add(new Cliente(nome, email));
    }

    public void cadastrarEvento(String nome, int dias, double valorDiario, int capacidade, boolean isShow) {
        if (isShow) {
            eventos.add(new Show(nome, dias, valorDiario, capacidade));
        } else {
            eventos.add(new Congresso(nome, dias, valorDiario, capacidade));
        }
    }

    public void listarEventos() {
        for (Evento evento : eventos) {
            System.out.println("Evento: " + evento.getNome() + " | Dias: " + evento.getDias() +
                               " | Valor Diário: R$ " + evento.getValorDiario() +
                               " | Capacidade: " + evento.getCapacidade() +
                               (evento instanceof Show ? " | Capacidade VIP: " + ((Show) evento).getCapacidadeVip() : "") +
                               " | Valor do Ingresso: R$ " + evento.calcularValorTotalIngresso() +
                               " | Ingressos Vendidos: " + evento.getIngressosVendidos());
        }
    }

    public void comprarIngresso(String nomeCliente, String nomeEvento, boolean isVip) {
        Cliente cliente = clientes.stream().filter(c -> c.getNome().equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);
        Evento evento = eventos.stream().filter(e -> e.getNome().equalsIgnoreCase(nomeEvento)).findFirst().orElse(null);

        if (cliente == null || evento == null) {
            System.out.println("Cliente ou evento não encontrado!");
            return;
        }

        if (!evento.haVagasDisponiveis(isVip)) {
            System.out.println("Evento lotado! Não há mais vagas disponíveis.");
            return;
        }

        double valorIngresso = evento.calcularValorIngresso(isVip);
        evento.venderIngresso();
        cliente.adicionarIngresso(evento);

        System.out.println("Ingresso comprado para " + evento.getNome() + " por " + cliente.getNome() + ". Valor: R$ " + valorIngresso);
    }

    public void utilizarIngresso(String nomeCliente, String nomeEvento) {
        Cliente cliente = clientes.stream().filter(c -> c.getNome().equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);
        Evento evento = eventos.stream().filter(e -> e.getNome().equalsIgnoreCase(nomeEvento)).findFirst().orElse(null);

        if (cliente == null || evento == null || !cliente.possuiIngresso(evento)) {
            System.out.println("Cliente ou evento não encontrado ou ingresso não adquirido!");
            return;
        }

        System.out.println(cliente.getNome() + " utilizou ingresso para " + evento.getNome() + "!");
    }
}
