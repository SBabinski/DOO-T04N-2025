// Show.java
public class Show extends Evento {
    private int vipVendidos = 0;

    public Show(String nome, int duracaoDias, double valorDiario, int capacidade) {
        super(nome, duracaoDias, valorDiario, capacidade);
    }

    public boolean comprarIngresso(boolean vip) {
        if (vip) {
            int maxVip = (int) (capacidade * 0.1);
            if (vipVendidos < maxVip) {
                vipVendidos++;
                venderIngresso();
                return true;
            } else return false;
        } else if (temVaga()) {
            venderIngresso();
            return true;
        }
        return false;
    }

    public double calcularValor(boolean vip) {
        return vip ? valorDiario * duracaoDias * 1.5 : valorDiario * duracaoDias;
    }

    public String getTipo() {
        return "Show";
    }
}
