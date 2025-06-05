package Calculadora;

import java.awt.*;
import javax.swing.*;

public class CalculadoraGUI extends JFrame {

    private JTextField num1Field = new JTextField();
    private JTextField num2Field = new JTextField();
    private JLabel resultadoLabel = new JLabel("Resultado: ");

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Número 1:")); add(num1Field);
        add(new JLabel("Número 2:")); add(num2Field);

        addButton("+"); addButton("-");
        addButton("×"); addButton("÷");

        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultadoLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButton(String op) {
        JButton btn = new JButton(op);
        btn.addActionListener(e -> calcular(op));
        add(btn);
    }

    private void calcular(String op) {
        try {
            double n1 = parseNumero(num1Field.getText());
            double n2 = parseNumero(num2Field.getText());

            double res = switch (op) {
                case "+" -> n1 + n2;
                case "-" -> n1 - n2;
                case "×" -> n1 * n2;
                case "÷" -> {
                    if (n2 == 0) throw new EntradaInvalidaException("Divisão por zero!");
                    yield n1 / n2;
                }
                default -> throw new EntradaInvalidaException("Operação inválida.");
            };

            resultadoLabel.setText("Resultado: " + res);
        } catch (EntradaInvalidaException e) {
            resultadoLabel.setText("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: entrada inválida.");
        }
    }

    private double parseNumero(String txt) throws EntradaInvalidaException {
        if (txt.isBlank())
            throw new EntradaInvalidaException("Campo vazio!");
        return Double.parseDouble(txt);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}