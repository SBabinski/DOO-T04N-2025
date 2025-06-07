import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Evento {
    private int id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int maxClientes;
    private double valorIngressoDiario;
    protected int totalIngressosVendidos; 

    public Evento(int id, String nome, LocalDate dataInicio, LocalDate dataFim, int maxClientes, double valorIngressoDiario) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.maxClientes = maxClientes;
        this.valorIngressoDiario = valorIngressoDiario;
        this.totalIngressosVendidos = 0;
    }
    
    public int getId() { 
        return id; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public LocalDate getDataInicio() { 
        return dataInicio; 
    }
    
    public LocalDate getDataFim() { 
        return dataFim; 
    }
    
    public int getMaxClientes() { 
        return maxClientes; 
    }
    
    public double getValorIngressoDiario() { 
        return valorIngressoDiario; 
    }
    
    public int getTotalIngressosVendidos() { 
        return totalIngressosVendidos; 
    }

    public long getDuracao() {
        return ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
    }

    public boolean isDisponivel() {
        return totalIngressosVendidos < maxClientes;
    }
    
    public boolean venderIngresso() {
        if (isDisponivel()) {
            totalIngressosVendidos++;
            return true;
        }
        return false;
    }
    
    public abstract double calcularValorIngresso(String tipo);

    @Override
    public String toString() {
        return "Evento [id=" + id + ", nome=" + nome 
            + ", de " + dataInicio + " a " + dataFim 
            + ", maxClientes=" + maxClientes 
            + ", vendidos=" + totalIngressosVendidos + "]";
    }
}
