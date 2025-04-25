import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private int dataCriacaoPedido;
    private int dataPagamentoPedido;
    private int dataVencimentoReservaPedido;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private ArrayList <Item> listaDeItensPedido = new ArrayList<>();

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getDataCriacaoPedido() {
        return dataCriacaoPedido;
    }
    public void setDataCriacaoPedido(int dataCriacaoPedido) {
        this.dataCriacaoPedido = dataCriacaoPedido;
    }
    public int getDataPagamentoPedido() {
        return dataPagamentoPedido;
    }
    public void setDataPagamentoPedido(int dataPagamentoPedido) {
        this.dataPagamentoPedido = dataPagamentoPedido;
    }
    public int getDataVencimentoReservaPedido() {
        return dataVencimentoReservaPedido;
    }
    public void setDataVencimentoReservaPedido(int dataVencimentoReservaPedido) {
        this.dataVencimentoReservaPedido = dataVencimentoReservaPedido;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Loja getLoja() {
        return loja;
    }
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    public ArrayList<Item> getListaDeItensPedido() {
        return listaDeItensPedido;
    }
    public void setListaDeItensPedido(ArrayList<Item> listaDeItensPedido) {
        this.listaDeItensPedido = listaDeItensPedido;
    }
    public Pedido() {
        super();
    }
    public Pedido(int idPedido, int dataCriacaoPedido, int dataPagamentoPedido, int dataVencimentoReservaPedido,
                     Cliente cliente, Vendedor vendedor, Loja loja) {
        this.idPedido = idPedido;
        this.dataCriacaoPedido = dataCriacaoPedido;
        this.dataPagamentoPedido = dataPagamentoPedido;
        this.dataVencimentoReservaPedido = dataVencimentoReservaPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
    }
    @Override
    public String toString() {
        return "ID do Pedido: " + getIdPedido() +
        ", Data de Criação: " + getDataCriacaoPedido() +
        ", Data de Pagamento: " + getDataPagamentoPedido() +
        ", Data de Vencimento: " + getDataVencimentoReservaPedido() +
        ", Cliente: " + getCliente() +
        ", Vendedor: " + getVendedor() +
        ", Loja: " + getLoja() +
        ", Itens: ";
    }

    public String exibirNomeItens() {
        StringBuilder itensStr = new StringBuilder();
        for (Item item : listaDeItensPedido) {
            itensStr.append(item.getNome()).append(", ");
        }
        return itensStr.toString().isEmpty() ? "Nenhum item cadastrado" : itensStr.toString();
    }
}
