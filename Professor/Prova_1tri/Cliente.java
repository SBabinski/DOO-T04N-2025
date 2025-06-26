public class Cliente {
    static int countId = 1;
    int id;
    String nome;
    String cpf;

    public Cliente(String nome, String cpf) {
        this.id = countId;
        this.nome = nome;
        this.cpf = cpf;
        countId++;
    }

    @Override
    public String toString() {
        return 
            "ID: " + id +
            "\nNome: " + nome +
            "\nCPF: " + cpf;
    }

}
