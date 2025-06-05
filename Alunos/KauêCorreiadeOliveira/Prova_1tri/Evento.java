import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
    public String nome;
    public String tipo; 
    public LocalDate dataInicio;
    public LocalDate dataFim;
    public double valorDiario;
    public int capacidadeMaxima;
    public ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Evento(String nome, String tipo, LocalDate dataInicio, LocalDate dataFim, double valorDiario, int capacidadeMaxima) {
        this.nome = nome;
        this.tipo = tipo.toLowerCase();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDiario = valorDiario;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public long getDuracaoDias() {
        return java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
    }

    public boolean temVaga() {
        return ingressos.size() < capacidadeMaxima;
    }

    public boolean temVagaVIP() {
        long vipCount = ingressos.stream().filter(i -> i.vip).count();
        return vipCount < capacidadeMaxima * 0.1;
    }

    public double calcularValorIngresso(boolean vip) {
        double valor = valorDiario * getDuracaoDias();
        if (tipo.equals("show") && vip) {
            return valor * 1.5;
        }
        return valor;
    }

    public boolean adicionarIngresso(Ingresso ingresso) {
        if (temVaga()) {
            ingressos.add(ingresso);
            return true;
        }
        return false;
    }
}
