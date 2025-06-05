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
        setSize(400, 250);
        setLayout(new GridLayout(6, 2));
        getContentPane().setBackground(new Color(240, 240, 240));  // Cor de fundo mais suave

        
        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton botaoSoma = new JButton("+");
        JButton botaoSubtrai = new JButton("-");
        JButton botaoMultiplica = new JButton("×");
        JButton botaoDivide = new JButton("÷");

        
      
      
        botaoSoma.setBackground(new Color(200, 255, 200));
        botaoSubtrai.setBackground(new Color(255, 200, 200));
        botaoMultiplica.setBackground(new Color(200, 255, 255));
        botaoDivide.setBackground(new Color(255, 255, 200));

        
        Font fonteBotao = new Font("Arial", Font.BOLD, 18);
        botaoSoma.setFont(fonteBotao);
        botaoSubtrai.setFont(fonteBotao);
        botaoMultiplica.setFont(fonteBotao);
        botaoDivide.setFont(fonteBotao);

        
        add(new JLabel("Número 1:"));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);
        add(botaoSoma);
        add(botaoSubtrai);
        add(botaoMultiplica);
        add(botaoDivide);
        add(resultadoLabel);

        
        botaoSoma.addActionListener(e -> executarOperacao('+'));
        botaoSubtrai.addActionListener(e -> executarOperacao('-'));
        botaoMultiplica.addActionListener(e -> executarOperacao('*'));
        botaoDivide.addActionListener(e -> executarOperacao('/'));

        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    private void executarOperacao(char operador) {
        try {
            double num1 = parseInput(campoNumero1.getText());
            double num2 = parseInput(campoNumero2.getText());

            double resultado = calcular(num1, num2, operador);
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (InputException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Oops! Algo deu errado...", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado! Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseInput(String texto) throws InputException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new InputException("Oops! Parece que você não digitou um número válido. Tente novamente.");
        }
    }

    private double calcular(double num1, double num2, char operador) throws InputException {
        switch (operador) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) throw new InputException("Ei! Não podemos dividir por zero. Tente outro número.");
                return num1 / num2;
            default:
                throw new InputException("Desculpe, operação inválida. Tente novamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
