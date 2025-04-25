package gabrielinha;

public class Item {
    int id;
    String nomeItem;
    String tipo;
    Float valor;

    public void gerarDescricao(){
        System.out.println("Item: "+nomeItem+
        "\nid: "+id+"\nTipo: "+tipo+"\nValor: "+valor);
    }
}
