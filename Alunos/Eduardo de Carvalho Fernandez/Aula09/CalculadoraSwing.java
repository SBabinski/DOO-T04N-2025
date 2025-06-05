package Fag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class CalculadoraSwing extends JFrame {
    private JTextField campoNumero1, campoNumero2;
    private JButton botaoSoma, botaoSubtrai, botaoMultiplica, botaoDivide;
    private JLabel resultadoLabel;

    public CalculadoraSwing() {
        setTitle("Calculadora TOPZERA");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();

        botaoSoma = new JButton("+");
        botaoSubtrai = new JButton("-");
        botaoMultiplica = new JButton("×");
        botaoDivide = new JButton("÷");

        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);

        add(botaoSoma);
        add(botaoSubtrai);
        add(botaoMultiplica);
        add(botaoDivide);
        add(new JLabel());
        add(resultadoLabel);


        botaoSoma.addActionListener(e -> realizarOperacao('+'));
        botaoSubtrai.addActionListener(e -> realizarOperacao('-'));
        botaoMultiplica.addActionListener(e -> realizarOperacao('*'));
        botaoDivide.addActionListener(e -> realizarOperacao('/'));

        setVisible(true);
    }

    private void realizarOperacao(char operacao) {
        try {
            double num1 = parseEntrada(campoNumero1.getText());
            double num2 = parseEntrada(campoNumero2.getText());

            double resultado = switch (operacao) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        throw new EntradaInvalidaException("Erro: Divisão por zero!");
                    }
                    yield num1 / num2;
                }
                default -> throw new IllegalArgumentException("Operação inválida");
            };

            resultadoLabel.setText("Resultado: " + resultado);
        } catch (EntradaInvalidaException ex) {
            mostrarErro(ex.getMessage());
        } catch (Exception ex) {
            mostrarErro("Erro inesperado: " + ex.getMessage());
        }
    }

    private double parseEntrada(String texto) throws EntradaInvalidaException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Erro: Entrada inválida! Use apenas números.");
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraSwing::new);
    }
}
