import java.util.ArrayList;
import java.util.List;

public class Evento {
    String nome;
    int vagasTotais;
    int vagasDisponiveis;
    double valorDiario;
    List<Cliente> participantes;

    public Evento(String nome, int vagasTotais, double valorDiario) {
        this.nome = nome;
        this.vagasTotais = vagasTotais;
        this.vagasDisponiveis = vagasTotais;
        this.valorDiario = valorDiario;
        this.participantes = new ArrayList<>();
    }

    public boolean temVagas() {
        return vagasDisponiveis > 0;
    }

    public void comprarIngresso(Cliente cliente) {
        if (temVagas()) {
            participantes.add(cliente);
            vagasDisponiveis--;
            System.out.println(cliente.getNome() + " comprou um ingresso para " + nome);
        } else {
            System.out.println("Sem vagas para o evento " + nome);
        }
    }

    public void listarParticipantes() {
        System.out.println("Participantes do evento " + nome + ":");
        for (Cliente c : participantes) {
            System.out.println(c.getNome());
        }
    }

    public double calcularValorIngresso(int dias) {
        return valorDiario * dias;
    }

    public double getValorDiario() {
        return valorDiario;
    }
}
