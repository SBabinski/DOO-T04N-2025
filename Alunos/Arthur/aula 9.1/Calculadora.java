import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel resultadoLabel;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        resultadoLabel = new JLabel("Resultado: ");

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
        add(resultadoLabel);

        // Ações dos botões
        botaoSoma.addActionListener(e -> executarOperacao('+'));
        botaoSubtrai.addActionListener(e -> executarOperacao('-'));
        botaoMultiplica.addActionListener(e -> executarOperacao('*'));
        botaoDivide.addActionListener(e -> executarOperacao('/'));

        setVisible(true);
    }

    private void executarOperacao(char operador) {
        try {
            double num1 = parseInput(campoNumero1.getText());
            double num2 = parseInput(campoNumero2.getText());

            double resultado = calcular(num1, num2, operador);
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (InputException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseInput(String texto) throws InputException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new InputException("Entrada inválida! Digite apenas números.");
        }
    }

    private double calcular(double num1, double num2, char operador) throws InputException {
        switch (operador) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) throw new InputException("Divisão por zero não é permitida.");
                return num1 / num2;
            default:
                throw new InputException("Operação inválida.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
