import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class CalculadoraException extends Exception {
    public CalculadoraException(String mensagem) {
        super(mensagem);
    }
}

public class Calculadora extends JFrame {
    private JTextField campo1, campo2;
    private JLabel resultado;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel(new GridLayout(2, 2, 5, 5));
        campo1 = new JTextField();
        campo2 = new JTextField();
        painelEntrada.add(new JLabel("Número 1:"));
        painelEntrada.add(campo1);
        painelEntrada.add(new JLabel("Número 2:"));
        painelEntrada.add(campo2);

        JPanel painelBotoes = new JPanel(new GridLayout(2, 2, 5, 5));
        String[] operacoes = {"+", "-", "×", "÷"};
        for (String op : operacoes) {
            JButton botao = new JButton(op);
            botao.setBackground(Color.LIGHT_GRAY);
            botao.addActionListener(calcular(op));
            painelBotoes.add(botao);
        }

        resultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 16));

        add(painelEntrada, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(resultado, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO!", JOptionPane.ERROR_MESSAGE);
    }

    private ActionListener calcular(String operacao) {
        return e -> {
            try {
                double num1 = Double.parseDouble(campo1.getText());
                double num2 = Double.parseDouble(campo2.getText());
                resultado.setText("Resultado: " + operar(num1, num2, operacao));
            } catch (CalculadoraException ex) {
                mostrarErro(ex.getMessage());
            } catch (NumberFormatException ex) {
                mostrarErro("Entrada inválida!");
            }
        };
    }

    private double operar(double num1, double num2, String operacao) throws CalculadoraException {
        if (operacao.equals("÷") && num2 == 0) {
            throw new CalculadoraException("Erro: Divisão por zero!");
        }

        return switch (operacao) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "×" -> num1 * num2;
            case "÷" -> num1 / num2;
            default -> throw new CalculadoraException("Operação inválida!");
        };
    }
    public static void main(String[] args) {
        new Calculadora();
    }
}
