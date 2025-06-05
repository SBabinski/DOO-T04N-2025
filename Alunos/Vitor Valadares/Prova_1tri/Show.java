package prova1tri;

import java.time.LocalDate;

public class Show extends Evento {
    private double adicionalVIP;

    public Show(String nome, LocalDate inicio, LocalDate fim, double preco, int capacidade, double adicionalVIP) {
        super(nome, inicio, fim, preco, capacidade);
        this.adicionalVIP = adicionalVIP;
    }

    @Override
    public double calcularValorIngresso() {
        
        return precoDiario * getDuracao() + adicionalVIP;
    }

  
    public double calcularValorVIP() {
        return precoDiario + adicionalVIP;
    }

    
    public boolean comprarVIP(Cliente cliente) {
        
        return true;
    }
}
