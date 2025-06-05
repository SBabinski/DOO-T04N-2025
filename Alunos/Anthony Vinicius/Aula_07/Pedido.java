package sistemamyplant;

import java.util.*;
import java.text.SimpleDateFormat;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private ClienteMyPlant cliente;
    private FuncionarioMyPlant vendedor;
    private LojaMyPlant loja;
    private List<Item> itens;

   
    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, ClienteMyPlant cliente, FuncionarioMyPlant vendedor, LojaMyPlant loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>();
    }

    
    public void adicionarItem(Item item) {
        itens.add(item);
    }

 
    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    
    public void gerarDescricaoVenda() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataCriacaoFormatada = sdf.format(dataCriacao);
        System.out.println("Pedido #" + id + " - Criado em: " + dataCriacaoFormatada);
        System.out.println("Valor total: R$" + String.format("%.2f", calcularValorTotal()));
    }

  
    public boolean verificarPagamento() {
        return dataPagamento != null && dataPagamento.before(dataVencimentoReserva);
    }

    
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public ClienteMyPlant getCliente() {
        return cliente;
    }

    public FuncionarioMyPlant getVendedor() {
        return vendedor;
    }

    public LojaMyPlant getLoja() {
        return loja;
    }
}
