package calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe principal
public class CalculadoraSwing extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel labelResultado;

    public CalculadoraSwing() {
        setTitle("Calculadora Simples");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes da interface
        add(new JLabel("Número 1:"));
        campoNumero1 = new JTextField();
        add(campoNumero1);

        add(new JLabel("Número 2:"));
        campoNumero2 = new JTextField();
        add(campoNumero2);

        JButton botaoSomar = new JButton("+");
        JButton botaoSubtrair = new JButton("-");
        JButton botaoMultiplicar = new JButton("×");
        JButton botaoDividir = new JButton("÷");

        add(botaoSomar);
        add(botaoSubtrair);
        add(botaoMultiplicar);
        add(botaoDividir);

        labelResultado = new JLabel("Resultado: ");
        labelResultado.setHorizontalAlignment(JLabel.CENTER);
        add(labelResultado);

        // Ações dos botões
        botaoSomar.addActionListener(e -> calcular('+'));
        botaoSubtrair.addActionListener(e -> calcular('-'));
        botaoMultiplicar.addActionListener(e -> calcular('*'));
        botaoDividir.addActionListener(e -> calcular('/'));
    }

    // Método de cálculo
    private void calcular(char operador) {
        try {
            double num1 = Double.parseDouble(campoNumero1.getText().trim());
            double num2 = Double.parseDouble(campoNumero2.getText().trim());
            double resultado;

            switch (operador) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '*': resultado = num1 * num2; break;
                case '/':
                    if (num2 == 0) throw new DivisaoPorZeroException();
                    resultado = num1 / num2;
                    break;
                default: throw new IllegalArgumentException("Operador inválido.");
            }

            labelResultado.setText("Resultado: " + resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite apenas números válidos.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        } catch (DivisaoPorZeroException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de cálculo", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Classe personalizada de exceção
    static class DivisaoPorZeroException extends Exception {
        public DivisaoPorZeroException() {
            super("Erro: Divisão por zero não é permitida.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraSwing().setVisible(true);
        });
    }
}
