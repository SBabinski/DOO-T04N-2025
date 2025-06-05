import java.util.*;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        
        sistema.cadastrarCliente("Cleitinho", "12345678900");

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JUNE, 10);
        Date inicio = cal.getTime();
        cal.set(2025, Calendar.JUNE, 12);
        Date fim = cal.getTime();

        sistema.cadastrarShow("Rock In Rio", inicio, fim, 150.0, 100);
        sistema.cadastrarCongresso("Java Conference", inicio, fim, 100.0, 50);

        Cliente cliente = new Cliente("Cleitinho", "12345678900");

        sistema.comprarIngresso("Rock In Rio", cliente, true);
        sistema.comprarIngresso("Java Conference", cliente, false);

        sistema.listarEventos();
    }
}
