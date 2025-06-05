import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) { super(message); }
    }
    
    static class OperationNotSupportedException extends Exception {
        public OperationNotSupportedException(String message) { super(message); }
    }
    
    static class OverflowException extends Exception {
        public OverflowException(String message) { super(message); }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Avançada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());


        JPanel resultPanel = new JPanel(new BorderLayout());
        JTextField display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(240, 240, 240));
        resultPanel.add(display, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        

        String[] buttons = {
            "C", "⌫", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "±", "0", ".", "="
        };

        for (String text : buttons) {
            JButton btn = createButton(text, display);
            buttonPanel.add(btn);
        }


        frame.add(resultPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createButton(String text, JTextField display) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        
        if (text.matches("[0-9]")) {
            button.setBackground(new Color(240, 240, 240));
        } else if (text.equals("C")) {
            button.setBackground(new Color(255, 100, 100));
            button.setForeground(Color.WHITE);
        } else if (text.equals("=")) {
            button.setBackground(new Color(70, 130, 180));
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(new Color(220, 220, 220));
        }

        button.addActionListener(e -> {
            try {
                handleButtonClick(text, display);
            } catch (InvalidInputException | OperationNotSupportedException | 
                    OverflowException ex) {
                display.setText("Erro: " + ex.getMessage());
            }
        });

        return button;
    }

    private static void handleButtonClick(String text, JTextField display) 
            throws InvalidInputException, OperationNotSupportedException, OverflowException {
            
        String currentText = display.getText();
        
        switch (text) {
            case "C":
                display.setText("0");
                break;
                
            case "⌫":
                if (currentText.length() > 1) {
                    display.setText(currentText.substring(0, currentText.length()-1));
                } else {
                    display.setText("0");
                }
                break;
                
            case "±":
                if (!currentText.equals("0")) {
                    if (currentText.startsWith("-")) {
                        display.setText(currentText.substring(1));
                    } else {
                        display.setText("-" + currentText);
                    }
                }
                break;
                
            case "=":
                calculateResult(display);
                break;
                
            default:
                if (currentText.equals("0") && !text.equals(".")) {
                    display.setText(text);
                } else {
                    display.setText(currentText + text);
                }
        }
    }

    private static void calculateResult(JTextField display) 
            throws InvalidInputException, OperationNotSupportedException, OverflowException {
            
        String expression = display.getText();
        
        try {
            if (!expression.matches("^[0-9+\\-×÷%.]+$")) {
                throw new InvalidInputException("Caractere inválido!");
            }
            
            String evalExpr = expression.replace("×", "*").replace("÷", "/").replace("%", "/100");
            
            if (evalExpr.contains("/0")) {
                throw new InvalidInputException("Divisão por zero!");
            }
            
            double result = evaluateExpression(evalExpr);
                
            if (Double.isInfinite(result)) {
                throw new OverflowException("Overflow numérico!");
            }
            
            if (result == (long) result) {
                display.setText(String.format("%d", (long) result));
            } else {
                display.setText(String.format("%s", result));
            }
            
        } catch (Exception e) {
            throw new OperationNotSupportedException("Operação inválida!");
        }
    }
    
    private static double evaluateExpression(String expression) {
        return new Object() {
            int pos = -1, ch;
            
            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }
            
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Caractere inesperado: " + (char)ch);
                return x;
            }
            
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }
            
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }
            
            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();
                
                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Caractere inesperado: " + (char)ch);
                }
                
                return x;
            }
        }.parse();
    }
}