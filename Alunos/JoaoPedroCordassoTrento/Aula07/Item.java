public class Item {
    private int idProduto;
    private String nome;
    private String tipo;
    private double valor;

    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Item() {
        super();
    }
    public Item(int idProduto, String nome, String tipo, double valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "ID do Produto: " + getIdProduto() +
           ", Nome: " + getNome() + 
           ", Tipo: " + getTipo() + 
           ", Valor: R$" + getValor(); 
    }
}
