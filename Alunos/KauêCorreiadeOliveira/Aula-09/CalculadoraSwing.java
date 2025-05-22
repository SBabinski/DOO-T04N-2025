import java.awt.*;
import javax.swing.*;

public class CalculadoraSwing extends JFrame {
    private JTextField campo1, campo2, resultado;
    private JButton somar, subtrair, multiplicar, dividir;

    public CalculadoraSwing() {
        setTitle("Calculadora Simples");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); 

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(240, 248, 255)); 

        JPanel painelEntradas = new JPanel(new GridBagLayout());
        painelEntradas.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        campo1 = new JTextField(10);
        campo2 = new JTextField(10);
        resultado = new JTextField(20);
        resultado.setEditable(false);
        resultado.setBackground(Color.WHITE);
        resultado.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0; gbc.gridy = 0;
        painelEntradas.add(new JLabel("Número 1:"), gbc);
        gbc.gridx = 1;
        painelEntradas.add(campo1, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painelEntradas.add(new JLabel("Número 2:"), gbc);
        gbc.gridx = 1;
        painelEntradas.add(campo2, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        painelEntradas.add(new JLabel("Resultado:"), gbc);
        gbc.gridx = 1;
        painelEntradas.add(resultado, gbc);

        painelPrincipal.add(painelEntradas, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        painelBotoes.setBackground(new Color(224, 255, 255));

        somar = criarBotao("+");
        subtrair = criarBotao("-");
        multiplicar = criarBotao("×");
        dividir = criarBotao("÷");

        painelBotoes.add(somar);
        painelBotoes.add(subtrair);
        painelBotoes.add(multiplicar);
        painelBotoes.add(dividir);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        add(painelPrincipal);

        somar.addActionListener(e -> calcular("+"));
        subtrair.addActionListener(e -> calcular("-"));
        multiplicar.addActionListener(e -> calcular("*"));
        dividir.addActionListener(e -> calcular("/"));

        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setBackground(new Color(173, 216, 230));
        botao.setFocusPainted(false);
        return botao;
    }

    private void calcular(String operacao) {
        try {
            double num1 = parseInput(campo1.getText());
            double num2 = parseInput(campo2.getText());

            double res = switch (operacao) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        throw new InputException("Divisão por zero não é permitida.");
                    }
                    yield num1 / num2;
                }
                default -> throw new InputException("Operação inválida.");
            };

            resultado.setText(String.valueOf(res));
        } catch (InputException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseInput(String input) throws InputException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InputException("Entrada inválida. Digite apenas números.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraSwing::new);
    }
}
