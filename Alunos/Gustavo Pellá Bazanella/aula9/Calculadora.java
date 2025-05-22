import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {
    @SuppressWarnings("FieldMayBeFinal")
    private JTextField campo1;
    @SuppressWarnings("FieldMayBeFinal")
    private JTextField campo2;
    @SuppressWarnings("FieldMayBeFinal")
    private JLabel resultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JLabel("Resultado: ");

        JButton somar = new JButton("+");
        JButton subtrair = new JButton("-");
        JButton multiplicar = new JButton("×");
        JButton dividir = new JButton("÷");

        add(new JLabel("Número 1:"));
        add(campo1);
        add(new JLabel("Número 2:"));
        add(campo2);
        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);
        add(resultado);

        somar.addActionListener(e -> calcular("+"));
        subtrair.addActionListener(e -> calcular("-"));
        multiplicar.addActionListener(e -> calcular("*"));
        dividir.addActionListener(e -> calcular("/"));

        setVisible(true);
    }

    private void calcular(String operacao) {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double res = 0;

            switch (operacao) {
                case "+" -> res = num1 + num2;
                case "-" -> res = num1 - num2;
                case "*" -> res = num1 * num2;
                case "/" -> {
                    if (num2 == 0) throw new EntradaInvalidaException("Divisão por zero não é permitida.");
                    res = num1 / num2;
                }
            }
            resultado.setText("Resultado: " + res);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira apenas números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (EntradaInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}