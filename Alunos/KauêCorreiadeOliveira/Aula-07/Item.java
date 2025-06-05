public class Item {
    public Integer id;
    public String nome;
    public String tipo;
    public Double valor;

    public Item(Integer id, String nome, String tipo, Double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id + " \n Nome: " + nome + " \n Tipo: " + tipo + " \n Valor: R$" + valor);
    }
}
