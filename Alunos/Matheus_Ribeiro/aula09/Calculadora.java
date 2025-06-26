package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {
	public static void main(String[] args) {
        JFrame window = new JFrame("Calculadora Muito Massa");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelNum1 = new JLabel("Digite o 1º número:");
        labelNum1.setForeground(Color.WHITE);
        JTextField inputNum1 = new JTextField();

        JLabel labelNum2 = new JLabel("Digite o 2º número:");
        labelNum2.setForeground(Color.WHITE);
        JTextField inputNum2 = new JTextField();

        JLabel labelOperation = new JLabel("Escolha a operação:");
        labelOperation.setForeground(Color.WHITE);

        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton[] opButtons = {btnAdd, btnSub, btnMul, btnDiv};

        Color gray = new Color(200, 200, 200);
        Color darkGray = new Color(120, 120, 120);

        for (JButton btn : opButtons) {
            btn.setBackground(gray);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setOpaque(true);
            btn.setForeground(Color.BLACK);
        }

        JButton btnEquals = new JButton("=");
        btnEquals.setBackground(gray);
        btnEquals.setFocusPainted(false);
        btnEquals.setBorderPainted(false);
        btnEquals.setOpaque(true);
        btnEquals.setForeground(Color.BLACK);

        JLabel labelResult = new JLabel("Resultado: ");
        labelResult.setForeground(Color.WHITE);
        labelResult.setHorizontalAlignment(SwingConstants.CENTER);

        final String[] selectedOp = {null};

        ActionListener opListener = e -> {
            selectedOp[0] = ((JButton) e.getSource()).getText();

            for (JButton btn : opButtons) {
                if (btn.getText().equals(selectedOp[0])) {
                    btn.setBackground(darkGray);
                } else {
                    btn.setBackground(gray);
                }
            }
        };

        for (JButton btn : opButtons) {
            btn.addActionListener(opListener);
        }

        btnEquals.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(inputNum1.getText());
                double n2 = Double.parseDouble(inputNum2.getText());
                String op = selectedOp[0];
                double result = 0;

                if (op == null) {
                    JOptionPane.showMessageDialog(window,
                            "Escolha uma operação primeiro.",
                            "Operação não definida",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (op.equals("/") && n2 == 0) {
                    JOptionPane.showMessageDialog(window,
                            "Não é possível dividir por 0",
                            "Cálculo impossível",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                switch (op) {
                    case "+": result = n1 + n2; break;
                    case "-": result = n1 - n2; break;
                    case "*": result = n1 * n2; break;
                    case "/": result = n1 / n2; break;
                }

                labelResult.setText("Resultado: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window,
                        "Caracteres inválidos",
                        "Erro no cálculo",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(labelNum1);
        panel.add(inputNum1);
        panel.add(labelNum2);
        panel.add(inputNum2);
        panel.add(labelOperation);
        panel.add(new JLabel(""));
        panel.add(btnAdd);
        panel.add(btnSub);
        panel.add(btnMul);
        panel.add(btnDiv);
        panel.add(btnEquals);
        panel.add(labelResult);

        window.add(panel);
        window.setVisible(true);
    }
}
