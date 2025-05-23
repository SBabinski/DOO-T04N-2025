import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Exceção personalizada
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Calculator extends JFrame {

    private JTextField input1, input2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        super("Calculadora Simples");

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes
        input1 = new JTextField();
        input2 = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("×");
        divideButton = new JButton("÷");

        // Adicionando componentes à janela
        add(new JLabel("Número 1:"));
        add(input1);
        add(new JLabel("Número 2:"));
        add(input2);
        add(new JLabel("Resultado:"));
        add(resultField);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        // Ações dos botões
        addButton.addActionListener(e -> performOperation('+'));
        subtractButton.addActionListener(e -> performOperation('-'));
        multiplyButton.addActionListener(e -> performOperation('*'));
        divideButton.addActionListener(e -> performOperation('/'));

        setVisible(true);
    }

    private void performOperation(char operator) {
        try {
            double num1 = parseInput(input1.getText());
            double num2 = parseInput(input2.getText());

            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0)
                        throw new InvalidInputException("Erro: Divisão por zero.");
                    result = num1 / num2;
                    break;
                default:
                    throw new InvalidInputException("Operação inválida.");
            }

            resultField.setText(String.valueOf(result));
        } catch (InvalidInputException ex) {
            showError(ex.getMessage());
        } catch (Exception ex) {
            showError("Erro inesperado: " + ex.getMessage());
        }
    }

    private double parseInput(String text) throws InvalidInputException {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Entrada inválida: " + text);
        }
    }

    private void showError(String message) {
        resultField.setText("");
        JOptionPane.showMessageDialog(this, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}