package eventos;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SistemaEventos {
    // Lista de clientes e eventos (simplificado para o exemplo)
    private List<String> clientes = new ArrayList<>();
    private List<String> eventos = new ArrayList<>();

    // Método para cadastrar cliente
    public void cadastrarCliente(String nome, String cpf) {
        clientes.add("Nome: " + nome + ", CPF: " + cpf);
        System.out.println("Cliente cadastrado!");
    }

    // Método para cadastrar show
    public void cadastrarShow(String nome, LocalDate inicio, LocalDate fim, double preco, int capacidade) {
        eventos.add("Show: " + nome + ", Início: " + inicio + ", Fim: " + fim + ", Preço: " + preco + ", Capacidade: " + capacidade);
        System.out.println("Show cadastrado!");
    }

    // Método para cadastrar congresso
    public void cadastrarCongresso(String nome, LocalDate inicio, LocalDate fim, double preco, int capacidade) {
        eventos.add("Congresso: " + nome + ", Início: " + inicio + ", Fim: " + fim + ", Preço: " + preco + ", Capacidade: " + capacidade);
        System.out.println("Congresso cadastrado!");
    }

    // Método para listar eventos
    public void listarEventos() {
        System.out.println("Eventos cadastrados:");
        for (String evento : eventos) {
            System.out.println(evento);
        }
    }

    // Método para comprar ingresso (simplificado)
    public void comprarIngresso(int idx, String cpf, boolean vip) {
        System.out.println("Ingresso comprado para: " + eventos.get(idx) + " por " + cpf);
    }

    // Método para utilizar ingresso (simplificado)
    public void utilizarIngresso(String cpf) {
        System.out.println("Ingresso utilizado por: " + cpf);
    }
}

