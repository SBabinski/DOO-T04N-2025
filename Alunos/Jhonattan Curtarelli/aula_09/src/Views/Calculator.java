package Views;

import Exceptions.DivisionByZeroException;
import Exceptions.FieldsIsEmptyException;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame frame;
    private JPanel pnlField1;
    private JLabel lblVal1;
    private JTextField txtVal1;
    private JPanel pnlField2;
    private JLabel lblVal2;
    private JTextField txtVal2;
    private JPanel pnlButton;
    private JButton btnSum;
    private JPanel pnlResult;
    private JLabel lblResult;
    private JTextField txtResult;
    private JPanel pnlBase;
    private JButton btnMult;
    private JButton btnSub;
    private JButton btnDiv;
    private Double MAX_VALUE = 1_000_000.0;
    public Calculator() {
        frame = new JFrame("Calculadora");
        pnlBase = new JPanel();
        pnlBase.setLayout(new BoxLayout(pnlBase, BoxLayout.Y_AXIS));
        pnlBase.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // <editor-fold desc="Field1">
        pnlField1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblVal1 = new JLabel("Valor 1:");
        lblVal1.setFont(new Font("Arial", Font.BOLD, 16));

        txtVal1 = new JTextField(10);
        txtVal1.setFont(new Font("Arial", Font.PLAIN, 16));

        pnlField1.add(lblVal1);
        pnlField1.add(txtVal1);
        // </editor-fold>

        // <editor-fold desc="Field2">
        pnlField2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblVal2 = new JLabel("Valor 2:");
        lblVal2.setFont(new Font("Arial", Font.BOLD, 16));

        txtVal2 = new JTextField(10);
        txtVal2.setFont(new Font("Arial", Font.PLAIN, 16));

        pnlField2.add(lblVal2);
        pnlField2.add(txtVal2);
        // </editor-fold>

        // <editor-fold desc="Buttons">
        pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnSum = createStyledButton("+");
        btnSum.addActionListener(e -> {
            this.Calculate("+");

        });

        btnSub = createStyledButton("-");
        btnSub.addActionListener(e -> {
            this.Calculate("-");

        });

        btnMult = createStyledButton("*");
        btnMult.addActionListener(e -> {
            this.Calculate("*");

        });

        btnDiv = createStyledButton("/");
        btnDiv.addActionListener(e -> {
            this.Calculate("/");
        });

        pnlButton.add(btnSum);
        pnlButton.add(btnSub);
        pnlButton.add(btnMult);
        pnlButton.add(btnDiv);
        // </editor-fold>

        // <editor-fold desc="Result">
        pnlResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblResult = new JLabel("Resultado:");
        lblResult.setFont(new Font("Arial", Font.BOLD, 16));

        txtResult = new JTextField(10);
        txtResult.setFont(new Font("Arial", Font.PLAIN, 16));
        txtResult.setEditable(false);

        pnlResult.add(lblResult);
        pnlResult.add(txtResult);
        // </editor-fold>

        pnlBase.add(pnlField1);
        pnlBase.add(Box.createVerticalStrut(10)); // Espaço entre os campos
        pnlBase.add(pnlField2);
        pnlBase.add(Box.createVerticalStrut(10));
        pnlBase.add(pnlButton);
        pnlBase.add(Box.createVerticalStrut(10));
        pnlBase.add(pnlResult);

        frame.setContentPane(pnlBase);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void Calculate (String operation) {

        try {
            if (txtVal1.getText().isEmpty() || txtVal2.getText().isEmpty()) {
                throw new FieldsIsEmptyException("");
            }

            double val1 = Double.parseDouble(txtVal1.getText());
            double val2 = Double.parseDouble(txtVal2.getText());

            if(val1 > MAX_VALUE || val2 > MAX_VALUE){
                throw new StackOverflowError();
            }
            double result = 0;
            switch (operation) {
                case "+":
                    result = val1 + val2;
                    break;
                case "-":
                    result = val1 - val2;
                    break;
                case "*":
                    result = val1 * val2;
                    break;
                case "/":
                    if (val2 == 0 || val1 == 0) {
                        throw new DivisionByZeroException("Division by zero");
                    }
                    result = val1 / val2;
                    break;
            }
            txtResult.setText(String.valueOf(result));
        }catch (DivisionByZeroException e) {
            JOptionPane.showMessageDialog(frame, "Divisão por zero não é permitida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (FieldsIsEmptyException e){
            JOptionPane.showMessageDialog(frame, "Necessário preencher todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (StackOverflowError e){
            JOptionPane.showMessageDialog(frame, "Valor muito grande! valor limite de até 1 milhão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Ocorreu Um erro Inesperado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setPreferredSize(new Dimension(60, 40));
        return button;
    }
}
