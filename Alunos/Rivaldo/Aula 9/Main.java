import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora Simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 2, 5, 5));


        JTextField txtNum1 = new JTextField();
        JTextField txtNum2 = new JTextField();
        JLabel lblResult = new JLabel("Resultado: ");
        

        frame.add(new JLabel("Número 1:"));
        frame.add(txtNum1);
        frame.add(new JLabel("Número 2:"));
        frame.add(txtNum2);
        

        frame.add(criarBotao("+", txtNum1, txtNum2, lblResult));
        frame.add(criarBotao("-", txtNum1, txtNum2, lblResult));
        frame.add(criarBotao("×", txtNum1, txtNum2, lblResult));
        frame.add(criarBotao("÷", txtNum1, txtNum2, lblResult));
        
        frame.add(new JLabel());
        frame.add(lblResult);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton criarBotao(String operacao, JTextField txtNum1, JTextField txtNum2, JLabel lblResult) {
        JButton botao = new JButton(operacao);
        
        botao.addActionListener(e -> {
            try {
                double num1 = parseNumber(txtNum1.getText());
                double num2 = parseNumber(txtNum2.getText());
                double resultado = calcular(num1, num2, operacao);
                lblResult.setText("Resultado: " + resultado);
            } catch (InvalidInputException ex) {
                lblResult.setText("Erro: " + ex.getMessage());
            }
        });
        
        return botao;
    }


    private static double parseNumber(String texto) throws InvalidInputException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Digite um número válido!");
        }
    }


    private static double calcular(double num1, double num2, String operacao) throws InvalidInputException {
        switch (operacao) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "×": return num1 * num2;
            case "÷":
                if (num2 == 0) throw new InvalidInputException("Divisão por zero!");
                return num1 / num2;
            default: throw new InvalidInputException("Operação inválida!");
        }
    }
}