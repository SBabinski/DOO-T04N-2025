
import java.awt.*;
import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(320, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JTextField tela = new JTextField();
        tela.setEditable(false);
        tela.setFont(new Font("Arial", Font.BOLD, 30));
        tela.setHorizontalAlignment(JTextField.RIGHT);
        tela.setBackground(Color.WHITE);
        frame.add(tela, BorderLayout.NORTH);

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(5, 4, 5, 5));

        String[] textos = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        final StringBuilder expressao = new StringBuilder();
        final boolean[] resultadoMostrado = {false};

        for (String texto : textos) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 22));
            botoes.add(botao);

            botao.addActionListener(e -> {
                String comando = e.getActionCommand();

                if (comando.equals("C")) {
                    expressao.setLength(0);
                    tela.setText("");
                    resultadoMostrado[0] = false;

                } else if (comando.equals("=")) {
                    try {
                        String expr = expressao.toString();
                        double resultado = calcularExpressaoSimples(expr);
                        tela.setText(String.valueOf(resultado));
                        expressao.setLength(0);
                        expressao.append(resultado);
                        resultadoMostrado[0] = true;

                    } catch (ArithmeticException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Erro: " + ex.getMessage(),
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        expressao.setLength(0);
                        tela.setText("");
                        resultadoMostrado[0] = true;

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Erro: expressão inválida",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        expressao.setLength(0);
                        tela.setText("");
                        resultadoMostrado[0] = true;
                    }

                } else {
                    if (resultadoMostrado[0]) {
                        expressao.setLength(0);
                        tela.setText("");
                        resultadoMostrado[0] = false;
                    }
                    expressao.append(comando);
                    tela.setText(expressao.toString());
                }
            });
        }

        frame.add(botoes, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static double calcularExpressaoSimples(String expr) {
        expr = expr.replaceAll("\\s", "");

        char operador = 0;
        int pos = -1;
        for (int i = 1; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operador = c;
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return Double.parseDouble(expr);
        }

        double num1 = Double.parseDouble(expr.substring(0, pos));
        double num2 = Double.parseDouble(expr.substring(pos + 1));

        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador inválido");
        }
    }
}
