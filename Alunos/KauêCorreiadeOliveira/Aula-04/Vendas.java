public class Vendas {
    
    public Double preco;
    public Integer quantidade;
    public String desconto;
    public Integer dia;
    public Integer mes;

    public Vendas(Double preco, Integer quantidade, String desconto, Integer dia, Integer mes) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.dia = dia;
        this.mes = mes;

    }

    @Override
    public String toString() {
        return "Vendas [preco=" + preco + ", quantidade=" + quantidade + ", desconto=" + desconto + ", dia=" + dia
                + ", mes=" + mes + "]";
    }
    
}
