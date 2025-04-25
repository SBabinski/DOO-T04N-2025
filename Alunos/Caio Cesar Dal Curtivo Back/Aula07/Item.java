package Aula07;
public class Item {
    int id;
    String nome, tipo;
    double valor;

    Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    void gerarDescricao() {
        System.out.println("Item ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}
