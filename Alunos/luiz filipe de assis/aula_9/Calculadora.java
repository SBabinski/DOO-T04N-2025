package aula_9;
import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI extends JFrame {
    private JTextField display;
    private boolean novoNumero = true;

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(e -> clicarBotao(e.getActionCommand()));
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
    }

    private void clicarBotao(String texto) {
        try {
            if ("0123456789".contains(texto)) {
                if (novoNumero) {
                    display.setText(texto);
                    novoNumero = false;
                } else {
                    display.setText(display.getText() + texto);
                }
            } else if ("+-*/".contains(texto)) {
                String atual = display.getText();
                if (atual.isEmpty()) return;
                char ultimo = atual.charAt(atual.length() - 1);
                if ("+-*/".indexOf(ultimo) != -1) {
                    display.setText(atual.substring(0, atual.length() - 1) + texto);
                } else {
                    display.setText(atual + texto);
                }
                novoNumero = false;
            } else if ("=".equals(texto)) {
                double resultado = calcularExpressao(display.getText());
                if (resultado == (long) resultado) {
                    display.setText(String.valueOf((long) resultado));
                } else {
                    display.setText(String.valueOf(resultado));
                }
                novoNumero = true;
            } else if ("C".equals(texto)) {
                display.setText("");
                novoNumero = true;
            }
        } catch (EntradaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            display.setText("");
            novoNumero = true;
        }
    }

    private double calcularExpressao(String expressao) throws EntradaInvalidaException {
        String op = null;
        for (char c : new char[]{'+','-','*','/'}) {
            if (expressao.indexOf(c) > 0) {
                op = String.valueOf(c);
                break;
            }
        }
        if (op == null) throw new EntradaInvalidaException("Expressão inválida");

        String[] partes = expressao.split("\\" + op);
        if (partes.length != 2) throw new EntradaInvalidaException("Expressão inválida");

        double num1, num2;
        try {
            num1 = Double.parseDouble(partes[0]);
            num2 = Double.parseDouble(partes[1]);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Valor não numérico");
        }

        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) throw new EntradaInvalidaException("Divisão por zero");
                return num1 / num2;
            default:
                throw new EntradaInvalidaException("Operador inválido");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI().setVisible(true));
    }
}

