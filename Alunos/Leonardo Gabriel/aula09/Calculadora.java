package a;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private static double resultado = 0;  // Para armazenar o resultado da última operação

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Simples");
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel label1 = new JLabel("Número 1:");
        JTextField campo1 = new JTextField();

        JLabel label2 = new JLabel("Número 2:");
        JTextField campo2 = new JTextField();

        JLabel labelResultado = new JLabel("Resultado:");
        JTextField campoResultado = new JTextField();
        campoResultado.setEditable(false);

        JButton btnSoma = new JButton("+");
        JButton btnSubtrai = new JButton("-");
        JButton btnMultiplica = new JButton("*");
        JButton btnDivide = new JButton("/");

        ActionListener acao = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = 0;
                double num2 = 0;

                try {
                    num1 = (campo1.getText().isEmpty()) ? resultado : Double.parseDouble(campo1.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número 1 inválido. Digite um valor numérico.");
                    return;
                }

                try {
                    num2 = (campo2.getText().isEmpty()) ? 0 : Double.parseDouble(campo2.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número 2 inválido. Digite um valor numérico.");
                    return;
                }

                double tempResultado = 0;

                if (e.getSource() == btnSoma) {
                    tempResultado = num1 + num2;
                } else if (e.getSource() == btnSubtrai) {
                    tempResultado = num1 - num2;
                } else if (e.getSource() == btnMultiplica) {
                    tempResultado = num1 * num2;
                } else if (e.getSource() == btnDivide) {
                    if (num2 != 0) {
                        tempResultado = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Erro: divisão por zero.");
                        return;
                    }
                }

                resultado = tempResultado;
                campoResultado.setText(String.valueOf(resultado));
                campo1.setText(String.valueOf(resultado));
                campo2.setText("");
            }
        };

        btnSoma.addActionListener(acao);
        btnSubtrai.addActionListener(acao);
        btnMultiplica.addActionListener(acao);
        btnDivide.addActionListener(acao);

        frame.add(label1);
        frame.add(campo1);
        frame.add(label2);
        frame.add(campo2);
        frame.add(btnSoma);
        frame.add(btnSubtrai);
        frame.add(btnMultiplica);
        frame.add(btnDivide);
        frame.add(labelResultado);
        frame.add(campoResultado);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
