package CalculadoraSwing;

public class Operacoes {

    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) throws EntradaInvalidaException {
        if (b == 0) {
            throw new EntradaInvalidaException("Não é possível dividir por zero.");
        }
        return a / b;
    }
}
