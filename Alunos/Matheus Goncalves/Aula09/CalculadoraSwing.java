package Calcular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Exceção personalizada
class MinhaCalculadoraException extends Exception {
    private static final long serialVersionUID = 1L;

    public MinhaCalculadoraException(String mensagem) {
        super(mensagem);
    }
}

public class CalculadoraSwing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoNumero1, campoNumero2;
    private JLabel resultadoLabel;

    public CalculadoraSwing() {
        setTitle("Calculadora Simples");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes da interface
        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        resultadoLabel = new JLabel("Resultado: ", SwingConstants.CENTER);

        JButton btnSomar = new JButton("+");
        JButton btnSubtrair = new JButton("-");
        JButton btnMultiplicar = new JButton("×");
        JButton btnDividir = new JButton("÷");

        // Adicionando componentes à interface
        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);
        add(btnSomar);
        add(btnSubtrair);
        add(btnMultiplicar);
        add(btnDividir);
        add(resultadoLabel);

        // Ações dos botões
        btnSomar.addActionListener(e -> calcular('+'));
        btnSubtrair.addActionListener(e -> calcular('-'));
        btnMultiplicar.addActionListener(e -> calcular('*'));
        btnDividir.addActionListener(e -> calcular('/'));

        setVisible(true);
    }

    private void calcular(char operador) {
        try {
            double num1 = lerNumero(campoNumero1.getText());
            double num2 = lerNumero(campoNumero2.getText());
            double resultado;

            switch (operador) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '*': resultado = num1 * num2; break;
                case '/':
                    if (num2 == 0)
                        throw new MinhaCalculadoraException("Erro: divisão por zero.");
                    resultado = num1 / num2;
                    break;
                default: throw new MinhaCalculadoraException("Operação inválida.");
            }

            resultadoLabel.setText("Resultado: " + resultado);

        } catch (MinhaCalculadoraException ex) {
            mostrarErro(ex.getMessage());
        } catch (Exception ex) {
            mostrarErro("Erro inesperado: " + ex.getMessage());
        }
    }

    private double lerNumero(String texto) throws MinhaCalculadoraException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new MinhaCalculadoraException("Entrada inválida: insira apenas números.");
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSwing());
    }
}
