package CalculadoraSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {

    private JTextField campo1, campo2, resultado;
    private JButton somar, subtrair, multiplicar, dividir;

    public Calculadora() {
        setTitle("Calculadora Swing");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);

        somar = new JButton("+");
        subtrair = new JButton("-");
        multiplicar = new JButton("×");
        dividir = new JButton("÷");

        add(new JLabel("Número 1:"));
        add(campo1);
        add(new JLabel("Número 2:"));
        add(campo2);
        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);
        add(new JLabel("Resultado:"));
        add(resultado);

        somar.addActionListener(e -> calcular("+"));
        subtrair.addActionListener(e -> calcular("-"));
        multiplicar.addActionListener(e -> calcular("*"));
        dividir.addActionListener(e -> calcular("/"));

        setVisible(true);
    }

    private void calcular(String operador) {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double res = 0;

            switch (operador) {
                case "+":
                    res = Operacoes.somar(num1, num2);
                    break;
                case "-":
                    res = Operacoes.subtrair(num1, num2);
                    break;
                case "*":
                    res = Operacoes.multiplicar(num1, num2);
                    break;
                case "/":
                    res = Operacoes.dividir(num1, num2);
                    break;
            }

            resultado.setText(String.valueOf(res));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira apenas números válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (EntradaInvalidaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
