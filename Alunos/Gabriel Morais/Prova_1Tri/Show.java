package entities;

public class Show extends Evento {
    private double adicionalVip;
    private int vagasVip;
    private int vipUsadas;
    
    public Show(String nome, int dias, double precoDiario, int capacidade, double adicionalVip) {
        super(nome, dias, precoDiario, capacidade);
        this.adicionalVip = adicionalVip;
        this.vagasVip = (int) Math.ceil(capacidade * 0.1);
        this.vipUsadas = 0;
    }
    
    @Override
    public double calcularValor(boolean vip) {
        double valorDiario = getPrecoDiario();
        if (vip) {
            valorDiario += adicionalVip;
        }
        return valorDiario * getDias();
    }
    
    public boolean temVagasVip() {
        return vipUsadas < vagasVip && temVagas();
    }
    
    public boolean addParticipanteVip(Cliente cliente) {
        if (temVagasVip()) {
            vipUsadas++;
            return super.addParticipante(cliente);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" (Show) - Adicional VIP: R$%.2f/dia - Vagas VIP: %d/%d",
                                              adicionalVip, (vagasVip - vipUsadas), vagasVip);
    }
}