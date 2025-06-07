public class Main {
    private int totalVagasVip;
    private int ingressosVipVendidos;
    
    public Main(int id, String nome, java.time.LocalDate dataInicio, java.time.LocalDate dataFim, int maxClientes, double valorIngressoDiario) {
        super(id, nome, dataInicio, dataFim, maxClientes, valorIngressoDiario);
  
        this.totalVagasVip = (int)Math.ceil(maxClientes * 0.1);
        this.ingressosVipVendidos = 0;
    }
    
    @Override
    public double calcularValorIngresso(String tipo) {
        double valorBase = getValorIngressoDiario() * getDuracao();
        if(tipo.equalsIgnoreCase("VIP")){
        
            return valorBase * 1.5;
        } else {
            return valorBase;
        }
    }
    
    public boolean venderIngressoShow(String tipo) {
        if (!isDisponivel()) {
            System.out.println("Ingressos esgotados para o evento!");
            return false;
        }
        if(tipo.equalsIgnoreCase("VIP")) {
            if(ingressosVipVendidos < totalVagasVip) {
                ingressosVipVendidos++;
                venderIngresso(); 
                return true;
            } else {
                System.out.println("Ingressos VIP esgotados!");
                return false;
            }
        } else if (tipo.equalsIgnoreCase("Normal")) {
            return venderIngresso();
        } else {
            System.out.println("Tipo de ingresso inválido para show!");
            return false;
        }
    }
    
    public int getTotalVagasVip() {
        return totalVagasVip;
    }
    
    public int getIngressosVipVendidos() {
        return ingressosVipVendidos;
    }
    
    @Override
    public String toString() {
        return "EventoShow " + super.toString() 
            + ", Vagas VIP: " + totalVagasVip + ", VIP vendidos: " + ingressosVipVendidos;
    }
}
