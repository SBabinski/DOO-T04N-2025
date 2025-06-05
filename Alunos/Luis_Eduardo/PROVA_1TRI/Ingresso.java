package prova;

public class Ingresso {
    Cliente cliente;
    Evento evento;
    boolean vip;
    boolean usado = false;

    public Ingresso(Cliente cliente, Evento evento, boolean vip){
        this.cliente = cliente;
        this.evento = evento;
        this.vip = vip;
    }
    public void usarIngresso(){
        if (usado == true){
            System.out.println("Ingresso já foi usado");
        } else {
            System.out.println("Ingresso usado!");
            usado = true;
        }
    }
    @Override
    public String toString() {
        return ("Ingresso de " + cliente + " para o evento \"" + evento.nome);
    }
}
