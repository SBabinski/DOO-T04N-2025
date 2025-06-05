public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tomas", "tomas@email.com", 30);
        Cliente cliente2 = new Cliente("samuel", "samuel@email.com", 25);

        Evento congresso = new Congresso("Congresso de Java", 100, 150);

        congresso.comprarIngresso(cliente1);
        congresso.comprarIngresso(cliente2);

        congresso.listarParticipantes();

        Ingresso ingresso1 = new Ingresso(cliente1, congresso, 3);
        Ingresso ingresso2 = new Ingresso(cliente2, congresso, 2);

        System.out.println("Valor do ingresso de Tomas: " + ingresso1.calcularValor());
        System.out.println("Valor do ingresso de Samuel: " + ingresso2.calcularValor());
    }
}
