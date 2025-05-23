package fag;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculadora extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel resultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campoNumero1 = new JTextField(10);
        campoNumero2 = new JTextField(10);
        resultado = new JLabel("Resultado: ");

        JButton botaoSomar = new JButton("+");
        JButton botaoSubtrair = new JButton("-");
        JButton botaoMultiplicar = new JButton("×");
        JButton botaoDividir = new JButton("÷");

        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);

        add(botaoSomar);
        add(botaoSubtrair);
        add(botaoMultiplicar);
        add(botaoDividir);

        add(resultado);

        botaoSomar.addActionListener(e -> realizarOperacao("+"));
        botaoSubtrair.addActionListener(e -> realizarOperacao("-"));
        botaoMultiplicar.addActionListener(e -> realizarOperacao("*"));
        botaoDividir.addActionListener(e -> realizarOperacao("/"));
    }

    private void realizarOperacao(String operacao) {
        try {
            double numero1 = obterNumero(campoNumero1.getText());
            double numero2 = obterNumero(campoNumero2.getText());
            double res = 0;

            switch (operacao) {
                case "+":
                    res = numero1 + numero2;
                    break;
                case "-":
                    res = numero1 - numero2;
                    break;
                case "*":
                    res = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 == 0) {
                        throw new EntradaInvalidaException("Divisão por zero não é permitida.");
                    }
                    res = numero1 / numero2;
                    break;
            }

            resultado.setText("Resultado: " + res);

        } catch (EntradaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double obterNumero(String texto) throws EntradaInvalidaException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Entrada inválida. Digite apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadora = new Calculadora();
            calculadora.setVisible(true);
            calculadora.setLocationRelativeTo(null);
        });
    }
}
