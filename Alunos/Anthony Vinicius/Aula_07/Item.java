package sistemamyplant;

public class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    
    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        setValor(valor);  
    }

   
    public void gerarDescricao() {
        System.out.println("Item #" + id + " - " + nome + " (" + tipo + ") - R$" + String.format("%.2f", valor));
    }

   
    public double getValor() {
        return valor;
    }

    
    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do item não pode ser negativo.");
        }
        this.valor = valor;
    }

    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
