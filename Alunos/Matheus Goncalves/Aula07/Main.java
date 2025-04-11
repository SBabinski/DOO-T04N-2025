package aula07;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
	    public static void main(String[] args) {
	        
	        Gerente gerente = new Gerente("Carlos", 40, "Loja A", 3500.0);
	        gerente.apresentarse();
	        System.out.println("Média dos salários: R$ " + gerente.calcularMedia());
	        System.out.println("Bônus: R$ " + gerente.calcularBonus());

	        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Av. Paulista", 1000, "Próximo ao metrô");
	        endereco.apresentarLogradouro();

	        Item item1 = new Item(1, "Camisa", "Vestuário", 99.90);
	        Item item2 = new Item(2, "Calça", "Vestuário", 149.90);
	        item1.gerarDescricao();
	        item2.gerarDescricao();

	        
	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DATE, 2); 
	        Date vencimento = cal.getTime();

	        ProcessaPedido processador = new ProcessaPedido();
	        Pedido pedido = processador.processar(101, "João", "Vendedor A", "Loja A", Arrays.asList(item1, item2), vencimento);

	        if (pedido != null) {
	            pedido.gerarDescricaoVenda();
	        }
	    }
	}
