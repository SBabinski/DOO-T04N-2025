package calculadora;

import javax.swing.*;
import java.awt.*;

public class CalculadoraSwing extends JFrame {
    private JTextField campoNumero1, campoNumero2;
    private JButton botaoSomar, botaoSubtrair, botaoMultiplicar, botaoDividir, botaoLimpar;
    private JLabel labelResultado;

    public CalculadoraSwing() {
        setTitle("Calculadora Completa");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fonteGrande = new Font("Arial", Font.BOLD, 36);
        Font fonteMuitoGrande = new Font("Arial", Font.BOLD, 60);

        JPanel painelEntrada = new JPanel(new GridLayout(2, 2, 30, 30));

        JLabel label1 = new JLabel("Número 1:", JLabel.CENTER);
        label1.setFont(fonteGrande);
        campoNumero1 = new JTextField();
        campoNumero1.setFont(fonteGrande);

        JLabel label2 = new JLabel("Número 2:", JLabel.CENTER);
        label2.setFont(fonteGrande);
        campoNumero2 = new JTextField();
        campoNumero2.setFont(fonteGrande);

        painelEntrada.add(label1);
        painelEntrada.add(campoNumero1);
        painelEntrada.add(label2);
        painelEntrada.add(campoNumero2);
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));

        JPanel painelBotoes = new JPanel(new GridLayout(1, 5, 30, 30));

        botaoSomar = new JButton("+");
        botaoSubtrair = new JButton("-");
        botaoMultiplicar = new JButton("×");
        botaoDividir = new JButton("÷");
        botaoLimpar = new JButton("Limpar");

        JButton[] botoes = {botaoSomar, botaoSubtrair, botaoMultiplicar, botaoDividir, botaoLimpar};
        for (JButton botao : botoes) {
            botao.setFont(fonteMuitoGrande);
            painelBotoes.add(botao);
        }

        painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 200, 50, 200));

        labelResultado = new JLabel("Resultado: ", JLabel.CENTER);
        labelResultado.setFont(fonteMuitoGrande);

        add(painelEntrada, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.SOUTH);

        botaoSomar.addActionListener(_ -> realizarOperacao("+"));
        botaoSubtrair.addActionListener(_ -> realizarOperacao("-"));
        botaoMultiplicar.addActionListener(_ -> realizarOperacao("*"));
        botaoDividir.addActionListener(_ -> realizarOperacao("/"));
        botaoLimpar.addActionListener(_ -> limparCampos());
    }

    private void realizarOperacao(String operacao) {
        try {
            double num1 = obterNumero(campoNumero1.getText());
            double num2 = obterNumero(campoNumero2.getText());
            double resultado = 0;

            switch (operacao) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/":
                    if (num2 == 0) throw new InputException("Erro: Divisão por zero!");
                    resultado = num1 / num2;
                    break;
            }

            labelResultado.setText("Resultado: " + resultado);
        } catch (InputException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Entrada inválida. Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double obterNumero(String texto) throws InputException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new InputException("Erro: Campo vazio.");
        }
        return Double.parseDouble(texto);
    }

    private void limparCampos() {
        campoNumero1.setText("");
        campoNumero2.setText("");
        labelResultado.setText("Resultado: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSwing().setVisible(true));
    }
}
