package lucas.PROVA_1TRI;

public class Cliente {
    private String nomeCompleto;
    private String cpf;

    public Cliente(String nomeCompleto, String cpf) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", cpf, nomeCompleto);
    }
}


