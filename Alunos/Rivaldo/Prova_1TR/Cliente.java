import java.util.ArrayList;  // Certifique-se de importar ArrayList

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Ingresso> ingressos;  

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.ingressos = new ArrayList<>();  
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void usarIngresso(Evento evento) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEvento().equals(evento)) {
                if (ingresso.getDias() > 1) {
                    ingresso.diminuirDia();
                    System.out.println("Um dia foi utilizado. Dias restantes: " + ingresso.getDias());
                } else {
                    ingressos.remove(ingresso);
                    System.out.println("Ingresso usado e removido para o evento: " + evento);
                }
                return; 
            }
        }
        System.out.println("Cliente não tem ingresso para este evento.");
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return nome + " | CPF: " + cpf;
    }
}
