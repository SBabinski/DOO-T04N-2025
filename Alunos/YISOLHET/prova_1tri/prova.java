package eventos;

public class Cliente {
	
	private String nome;
	private String email;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
		
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	
		
	 @Override
	    public String toString() {
	        return nome + " (" + email + ")";
	    }

}

