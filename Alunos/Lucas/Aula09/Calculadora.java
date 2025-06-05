package AULA9;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel labelResultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        labelResultado = new JLabel("Resultado: ");

        JButton botaoSoma = new JButton("+");
        JButton botaoSubtrai = new JButton("-");
        JButton botaoMultiplica = new JButton("×");
        JButton botaoDivide = new JButton("÷");

        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);
        add(botaoSoma);
        add(botaoSubtrai);
        add(botaoMultiplica);
        add(botaoDivide);
        add(labelResultado);

        botaoSoma.addActionListener(e -> realizarOperacao('+'));
        botaoSubtrai.addActionListener(e -> realizarOperacao('-'));
        botaoMultiplica.addActionListener(e -> realizarOperacao('*'));
        botaoDivide.addActionListener(e -> realizarOperacao('/'));

        add(labelResultado);
        setVisible(true);
    }

    private void realizarOperacao(char operacao) {
        try {
            double num1 = obterNumero(campoNumero1.getText());
            double num2 = obterNumero(campoNumero2.getText());

            double resultado;

            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new CalculadoraException("Erro: Divisão por zero.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new CalculadoraException("Operação inválida.");
            }

            labelResultado.setText("Resultado: " + resultado);

        } catch (CalculadoraException ex) {
            mostrarErro(ex.getMessage());
        }
    }

    private double obterNumero(String texto) throws CalculadoraException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Entrada inválida: " + texto);
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}