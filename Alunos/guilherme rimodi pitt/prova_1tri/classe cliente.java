public class Cliente {
    private int id;
    private String nome;
    
    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public int getId() { 
        return id; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }
}
