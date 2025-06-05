package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraApp {

	public static void main(String[] args) {
	    JFrame frame = new JFrame("Calculadora Android Style");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(450, 250);
	    frame.setLayout(new BorderLayout(10, 10));
	    frame.getContentPane().setBackground(Color.BLACK); // Fundo preto

	    // Cores estilo Android
	    Color fundoBotao = new Color(255, 149, 0); // Laranja Android
	    Color textoBotao = Color.WHITE;
	    Font fonte = new Font("Segoe UI", Font.PLAIN, 16);

	    // Painel de entrada lado a lado
	    JPanel painelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
	    painelEntrada.setBackground(Color.BLACK);

	    JLabel lblNum1 = new JLabel("Número 1:");
	    lblNum1.setForeground(Color.WHITE);
	    JTextField txtNum1 = new JTextField(6);
	    txtNum1.setFont(fonte);

	    JLabel lblNum2 = new JLabel("Número 2:");
	    lblNum2.setForeground(Color.WHITE);
	    JTextField txtNum2 = new JTextField(6);
	    txtNum2.setFont(fonte);

	    painelEntrada.add(lblNum1);
	    painelEntrada.add(txtNum1);
	    painelEntrada.add(lblNum2);
	    painelEntrada.add(txtNum2);

	    // Painel de botões
	    JPanel painelBotoes = new JPanel(new GridLayout(1, 5, 10, 10));
	    painelBotoes.setBackground(Color.BLACK);

	    String[] simbolos = {"+", "-", "×", "÷", "Limpar"};
	    JButton[] botoes = new JButton[5];

	    for (int i = 0; i < simbolos.length; i++) {
	        botoes[i] = new JButton(simbolos[i]);
	        botoes[i].setFont(fonte);
	        botoes[i].setBackground(fundoBotao);
	        botoes[i].setForeground(textoBotao);
	        painelBotoes.add(botoes[i]);
	    }

	    // Painel do resultado
	    JPanel painelResultado = new JPanel(new GridLayout(2, 1));
	    painelResultado.setBackground(Color.BLACK);
	    JLabel lblResultado = new JLabel("Resultado:");
	    lblResultado.setForeground(Color.WHITE);
	    JLabel resultado = new JLabel("");
	    resultado.setFont(new Font("Arial", Font.BOLD, 20));
	    resultado.setForeground(new Color(255, 149, 0));
	    painelResultado.add(lblResultado);
	    painelResultado.add(resultado);

	    // Adiciona os painéis
	    frame.add(painelEntrada, BorderLayout.NORTH);
	    frame.add(painelBotoes, BorderLayout.CENTER);
	    frame.add(painelResultado, BorderLayout.SOUTH);

	    // Lógica
	    ActionListener operacaoListener = e -> {
	        try {
	            double num1 = lerNumero(txtNum1);
	            double num2 = lerNumero(txtNum2);
	            double res = 0;
	            String comando = e.getActionCommand();

	            switch (comando) {
	                case "+": res = num1 + num2; break;
	                case "-": res = num1 - num2; break;
	                case "×": res = num1 * num2; break;
	                case "÷":
	                    if (num2 == 0) throw new ArithmeticException("Divisão por zero não é permitida.");
	                    res = num1 / num2;
	                    break;
	            }

	            resultado.setText(String.valueOf(res));
	        } catch (EntradaInvalidaException ex) {
	            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro de Entrada", JOptionPane.WARNING_MESSAGE);
	        } catch (ArithmeticException ex) {
	            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro Matemático", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(frame, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    };

	    botoes[0].addActionListener(operacaoListener);
	    botoes[1].addActionListener(operacaoListener);
	    botoes[2].addActionListener(operacaoListener);
	    botoes[3].addActionListener(operacaoListener);

	    botoes[4].addActionListener(e -> {
	        txtNum1.setText("");
	        txtNum2.setText("");
	        resultado.setText("");
	    });

	    frame.setLocationRelativeTo(null); // Centraliza a janela
	    frame.setVisible(true);
	}


	
	public static double lerNumero(JTextField campo) throws EntradaInvalidaException {
	    String texto = campo.getText().trim();
	    if (texto.isEmpty()) {
	        throw new EntradaInvalidaException("Campo vazio. Por favor, insira um número. Grato... Ass: Dev");
	    }
	    try {
	        return Double.parseDouble(texto);
	    } catch (NumberFormatException e) {
	        throw new EntradaInvalidaException("Essa calculadora é simples, use apenas números. Grato... Ass: Dev");
	    }
	}

}