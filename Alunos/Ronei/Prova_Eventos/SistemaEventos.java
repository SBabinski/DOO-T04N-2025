// SistemaEventos.java
import java.util.*;

public class SistemaEventos {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado.");
    }

    public void cadastrarEvento(String tipo, String nome, int dias, double valor, int capacidade) {
        if (tipo.equalsIgnoreCase("show"))
            eventos.add(new Show(nome, dias, valor, capacidade));
        else
            eventos.add(new Congresso(nome, dias, valor, capacidade));
        System.out.println("Evento cadastrado.");
    }

    public void listarEventos() {
        for (int i = 0; i < eventos.size(); i++) {
            Evento e = eventos.get(i);
            System.out.printf("[%d] %s (%s)\n", i, e.nome, e.getTipo());
        }
    }

    public void comprarIngresso(int clienteIndex, int eventoIndex, boolean vip) {
        Cliente c = clientes.get(clienteIndex);
        Evento e = eventos.get(eventoIndex);
        if (e.comprarIngresso(vip)) {
            ingressos.add(new Ingresso(c, e, vip));
            System.out.println("Ingresso comprado com sucesso.");
        } else {
            System.out.println("Não há ingressos disponíveis.");
        }
    }

    public void usarIngresso(int index) {
        ingressos.get(index).usar();
    }

    public void listarIngressos() {
        for (int i = 0; i < ingressos.size(); i++) {
            System.out.println("[" + i + "] " + ingressos.get(i));
        }
    }
}
