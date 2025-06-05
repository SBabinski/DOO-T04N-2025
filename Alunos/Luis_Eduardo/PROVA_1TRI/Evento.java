package prova;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    String nome;
    int dias;
    double precoDiaria;
    int capacidade;
    List<Cliente> clientes = new ArrayList<>();

    public Evento(String nome, int dias, double precoDiaria,
    int capacidade){
        this.nome = nome;
        this.dias = dias;
        this. precoDiaria = precoDiaria;
        this. capacidade = capacidade;
    }

    public double calcularValorIngresso(boolean vip){
        return precoDiaria * dias;
    }

    public boolean Disponibilidade(boolean vip) {
        return clientes.size() < capacidade;
    }

    public void registrarParticipante (Cliente cliente){
        clientes.add(cliente);
    }

    public String apresentarEvento(){
        return nome + " - " + dias + " dias - R$" + precoDiaria + "/dia - Capacidade: " + capacidade + " - Participantes: " + clientes.size();
    }
}
