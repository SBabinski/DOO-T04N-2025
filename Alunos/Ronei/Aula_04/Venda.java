package aula03;

import java.util.Calendar;

public class Venda {

    private int qtdaPlantas;
    private double precoPlanta;
    private double desconto;
    private double precoTotal;
    private int mes;
    private int dia;

    public int getQtdaPlantas() {
        return qtdaPlantas;
    }

    public void setQtdaPlantas(int qtdaPlantas) {
        this.qtdaPlantas = qtdaPlantas;
    }

    public double getPrecoPlanta() {
        return precoPlanta;
    }

    public void setPrecoPlanta(double precoPlanta) {
        this.precoPlanta = precoPlanta;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    // Adicionando mês e dia
    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public Venda(int qtdaPlantas, double precoPlanta, double desconto, double precoTotal) {
        super();
        this.qtdaPlantas = qtdaPlantas;
        this.precoPlanta = precoPlanta;
        this.desconto = desconto;
        this.precoTotal = precoTotal;

        // Captura a data atual
        Calendar calendar = Calendar.getInstance();
        this.mes = calendar.get(Calendar.MONTH) + 1; // Os meses começam do 0, então somamos 1
        this.dia = calendar.get(Calendar.DAY_OF_MONTH); // Captura o dia do mês
    }

    public Venda() {
        super();
    }

    @Override
    public String toString() {
        return "Venda [Quantidade de Plantas = " + qtdaPlantas + ", Preço da Planta = R$" + precoPlanta + ", Desconto = " + desconto
                + "%, Preço Total = R$" + precoTotal + ", Mês = " + mes + ", Dia = " + dia + "]";
    }
}
