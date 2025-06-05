package eventos;


	import java.time.LocalDate;
	import java.util.HashSet;
	import java.util.Set;

	public abstract class Evento {
	    protected String nome;
	    protected LocalDate inicio;
	    protected LocalDate fim;
	    protected double precoDiario;
	    protected int capacidade;
	    protected Set<Ingresso> ingressos = new HashSet<>();

	    public Evento(String nome, LocalDate inicio, LocalDate fim, double precoDiario, int capacidade) {
	        this.nome = nome;
	        this.inicio = inicio;
	        this.fim = fim;
	        this.precoDiario = precoDiario;
	        this.capacidade = capacidade;
	    }

	    public boolean temVaga(boolean vip) {
	        long total = ingressos.size();
	        if (total >= capacidade) return false;
	        if (vip && !temVagaVip()) return false;
	        return true;
	    }

	    public void registrarIngresso(Ingresso ingresso) {
	        ingressos.add(ingresso);
	    }

	    public double calcularPreco(boolean vip) {
	        int dias = fim.compareTo(inicio) + 1;
	        return dias * precoDiario * (vip ? getMultiplicadorVip() : 1);
	    }
         
	   public String GetNome() {
	        return nome;
	    }

	    public boolean ingressoPertence(String nomeCliente) {
	        for (Ingresso i : ingressos) {
	            if (i.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public abstract boolean temVagaVip();
	    public abstract double getMultiplicadorVip();
	    public abstract String getTipo();
	}


