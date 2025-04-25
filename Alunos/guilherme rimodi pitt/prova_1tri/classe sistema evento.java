import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SistemaEvento {
    private List<Cliente> clientes;
    private List<Evento> eventos;
    private List<Ingresso> ingressos;
    
    private int clienteIdCounter = 1;
    private int eventoIdCounter = 1;
    private int ingressoIdCounter = 1;
    
    public SistemaEvento(){
        clientes = new ArrayList<>();
        eventos = new ArrayList<>();
        ingressos = new ArrayList<>();
    }
    
    public Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(clienteIdCounter++, nome);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente);
        return cliente;
    }
    
    public Evento cadastrarEvento(String tipo, String nome, LocalDate dataInicio, LocalDate dataFim, int maxClientes, double valorIngressoDiario) {
        Evento evento = null;
        if (tipo.equalsIgnoreCase("show")) {
            evento = new EventoShow(eventoIdCounter++, nome, dataInicio, dataFim, maxClientes, valorIngressoDiario);
        } else if (tipo.equalsIgnoreCase("congresso")) {
            evento = new EventoCongresso(eventoIdCounter++, nome, dataInicio, dataFim, maxClientes, valorIngressoDiario);
        }
        if (evento != null) {
            eventos.add(evento);
            System.out.println("Evento cadastrado: " + evento);
        }
        return evento;
    }
    public void listarEventos() {
        if(eventos.isEmpty()){
            System.out.println("Nenhum evento cadastrado.");
        } else {
            for (Evento evento : eventos) {
                System.out.println(evento);
            }
        }
    }
    
    public Ingresso comprarIngresso(int clienteId, int eventoId, String tipoIngresso) {
        Cliente cliente = buscarCliente(clienteId);
        Evento evento = buscarEvento(eventoId);
        if(cliente == null){
            System.out.println("Cliente não encontrado!");
            return null;
        }
        if(evento == null){
            System.out.println("Evento não encontrado!");
            return null;
        }
        
        boolean sucesso = false;
        if(evento instanceof EventoShow) {
            EventoShow show = (EventoShow) evento;
            sucesso = show.venderIngressoShow(tipoIngresso);
        } else {
            sucesso = evento.venderIngresso();
        }
        
        if(sucesso) {
            Ingresso ingresso = new Ingresso(ingressoIdCounter++, cliente, evento, tipoIngresso);
            ingressos.add(ingresso);
            System.out.println("Ingresso comprado com sucesso: " + ingresso);
            return ingresso;
        } else {
            System.out.println("Não foi possível comprar ingresso, sem disponibilidade.");
            return null;
        }
    }
    
    public void utilizarIngresso(int ingressoId) {
        Ingresso ingresso = buscarIngresso(ingressoId);
        if(ingresso == null){
            System.out.println("Ingresso não encontrado!");
        } else {
            ingresso.utilizar();
        }
    }
    
    private Cliente buscarCliente(int clienteId) {
        for(Cliente c : clientes) {
            if(c.getId() == clienteId) {
                return c;
            }
        }
        return null;
    }
    
    private Evento buscarEvento(int eventoId) {
        for(Evento e : eventos) {
            if(e.getId() == eventoId) {
                return e;
            }
        }
        return null;
    }
    
    private Ingresso buscarIngresso(int ingressoId) {
        for(Ingresso i : ingressos) {
            if(i.getId() == ingressoId) {
                return i;
            }
        }
        return null;
    }
  
    public Evento getEventoById(int id) {
        return buscarEvento(id);
    }
}
