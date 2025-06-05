package br.com.com.calculadora;

import br.com.com.calculadora.exception.EntradaInvalidaException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinhaCalculadora extends JFrame {

    private JTextField campoResultado, entrada1, entrada2;
    private JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao, botaoLimpar;
    private JLabel rotuloResultado;

    public MinhaCalculadora() {
        setTitle("Minha Calculadora");
        setSize(320, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        entrada1 = new JTextField(10);
        entrada2 = new JTextField(10);
        campoResultado = new JTextField(10);
        campoResultado.setEditable(false);
        rotuloResultado = new JLabel("Resultado:");

        botaoSoma = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("×");
        botaoDivisao = new JButton("÷");
        botaoLimpar = new JButton("Limpar");

        add(new JLabel("Valor 1:"));
        add(entrada1);
        add(new JLabel("Valor 2:"));
        add(entrada2);
        add(botaoSoma);
        add(botaoSubtracao);
        add(botaoMultiplicacao);
        add(botaoDivisao);
        add(botaoLimpar);
        add(rotuloResultado);
        add(campoResultado);

        botaoSoma.addActionListener(new AcaoOperacao("+"));
        botaoSubtracao.addActionListener(new AcaoOperacao("-"));
        botaoMultiplicacao.addActionListener(new AcaoOperacao("×"));
        botaoDivisao.addActionListener(new AcaoOperacao("÷"));
        botaoLimpar.addActionListener(e -> {
            entrada1.setText("");
            entrada2.setText("");
            campoResultado.setText("");
        });
    }

    private class AcaoOperacao implements ActionListener {
        private String operacao;
        public AcaoOperacao(String operacao) {
            this.operacao = operacao;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                double val1 = Double.parseDouble(entrada1.getText());
                double val2 = Double.parseDouble(entrada2.getText());
                double resultado = 0;

                switch (operacao) {
                    case "+": resultado = val1 + val2; break;
                    case "-": resultado = val1 - val2; break;
                    case "×": resultado = val1 * val2; break;
                    case "÷":
                        if (val2 == 0) throw new EntradaInvalidaException("Divisão por zero não permitida");
                        resultado = val1 / val2;
                        break;
                }
                campoResultado.setText(String.valueOf(resultado));
            } catch (EntradaInvalidaException ex) {
                campoResultado.setText("Erro: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                campoResultado.setText("Erro: Entrada inválida");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MinhaCalculadora().setVisible(true));
    }
}
