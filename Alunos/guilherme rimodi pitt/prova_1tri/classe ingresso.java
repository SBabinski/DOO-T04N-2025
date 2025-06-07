public class Ingresso {
    private int id;
    private Cliente cliente;
    private Evento evento;
    private String tipo; 
    private boolean utilizado;
    
    public Ingresso(int id, Cliente cliente, Evento evento, String tipo) {
        this.id = id;
        this.cliente = cliente;
        this.evento = evento;
        this.tipo = tipo;
        this.utilizado = false;
    }
    
    public int getId() { 
        return id; 
    }
    
    public Cliente getCliente() { 
        return cliente; 
    }
    
    public Evento getEvento() { 
        return evento; 
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public boolean isUtilizado() { 
        return utilizado; 
    }
    

    public void utilizar() {
        if(!utilizado){
            System.out.println("Ingresso utilizado com sucesso!");
            utilizado = true;
        } else {
            System.out.println("Este ingresso já foi utilizado!");
        }
    }
    

    public double calcularValor() {
        return evento.calcularValorIngresso(tipo);
    }
    
    @Override
    public String toString() {
        return "Ingresso [id=" + id 
            + ", cliente=" + cliente.getNome() 
            + ", evento=" + evento.getNome() 
            + ", tipo=" + tipo 
            + ", utilizado=" + (utilizado ? "Sim" : "Não")
            + ", valor=" + calcularValor() + "]";
    }
}
