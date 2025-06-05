// Congresso.java
public class Congresso extends Evento {
    public Congresso(String nome, int duracaoDias, double valorDiario, int capacidade) {
        super(nome, duracaoDias, valorDiario, capacidade);
    }

    public boolean comprarIngresso(boolean vip) {
        if (temVaga()) {
            venderIngresso();
            return true;
        }
        return false;
    }

    public double calcularValor(boolean vip) {
        return valorDiario * duracaoDias;
    }

    public String getTipo() {
        return "Congresso";
    }
}
