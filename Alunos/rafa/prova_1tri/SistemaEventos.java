package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaEventos {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    public void cadastrarCliente(String nome, String email) {
        clientes.add(new Cliente(nome, email));
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public boolean comprarIngresso(String nomeEvento, Cliente cliente, boolean vip) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nomeEvento)) {
                if (e.verificarDisponibilidade()) {
                    return e.adicionarParticipante(cliente);
                }
            }
        }
        return false;
    }

    public double calcularValorIngresso(String nomeEvento, boolean vip) {
        for (Evento e : eventos) {
            if (e.getNome().equalsIgnoreCase(nomeEvento)) {
                return e.calcularValorIngresso(vip);
            }
        }
        return 0;
    }
}
