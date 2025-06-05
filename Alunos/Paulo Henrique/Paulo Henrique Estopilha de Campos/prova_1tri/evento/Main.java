package evento;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cleitinho", "cleito@email.com", "111.111.111-11");

        Show show = new Show("Festa Sertaneja", 2, 100.0, 100);
        Congresso congresso = new Congresso("Congresso de TI", 3, 80.0, 200);

        EventoService service = new EventoService();
        service.cadastrarEvento(show);
        service.cadastrarEvento(congresso);

        service.listarEventos();

        Ingresso ingressoShow = service.comprarIngresso(show, cliente1, true);
        Ingresso ingressoCongresso = service.comprarIngresso(congresso, cliente1, false);

        if (ingressoShow != null) {
            System.out.println("Valor ingresso VIP show: R$" + ingressoShow.getValor());
            ingressoShow.usar();
        }

        if (ingressoCongresso != null) {
            System.out.println("Valor ingresso congresso: R$" + ingressoCongresso.getValor());
            ingressoCongresso.usar();
        }
    }
}
