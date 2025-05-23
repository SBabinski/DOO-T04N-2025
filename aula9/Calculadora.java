import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel labelResultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        painelEntrada.add(new JLabel("Número 1:"));
        campoNumero1 = new JTextField();
        painelEntrada.add(campoNumero1);
        painelEntrada.add(new JLabel("Número 2:"));
        campoNumero2 = new JTextField();
        painelEntrada.add(campoNumero2);
        add(painelEntrada, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(2, 2, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton botaoSoma = new JButton("+");
        JButton botaoSubtracao = new JButton("-");
        JButton botaoMultiplicacao = new JButton("×");
        JButton botaoDivisao = new JButton("÷");

        botaoSoma.addActionListener(e -> calcular('+'));
        botaoSubtracao.addActionListener(e -> calcular('-'));
        botaoMultiplicacao.addActionListener(e -> calcular('*'));
        botaoDivisao.addActionListener(e -> calcular('/'));

        painelBotoes.add(botaoSoma);
        painelBotoes.add(botaoSubtracao);
        painelBotoes.add(botaoMultiplicacao);
        painelBotoes.add(botaoDivisao);
        add(painelBotoes, BorderLayout.CENTER);

        JPanel painelResultado = new JPanel();
        labelResultado = new JLabel("Resultado: ");
        painelResultado.add(labelResultado);
        add(painelResultado, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void calcular(char operacao) {
        try {
            double num1 = parseNumero(campoNumero1.getText());
            double num2 = parseNumero(campoNumero2.getText());
            double resultado;

            switch (operacao) {
                case '+': resultado = num1 + num2; break;
                case '-': resultado = num1 - num2; break;
                case '*': resultado = num1 * num2; break;
                case '/':
                    if (num2 == 0) throw new CalculadoraException("Divisão por zero não é permitida.");
                    resultado = num1 / num2;
                    break;
                default:
                    throw new CalculadoraException("Operação inválida.");
            }

            labelResultado.setText("Resultado: " + resultado);
        } catch (CalculadoraException ex) {
            mostrarErro(ex.getMessage());
        } catch (Exception ex) {
            mostrarErro("Erro inesperado: " + ex.getMessage());
        }
    }

    private double parseNumero(String texto) throws CalculadoraException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new CalculadoraException("Entrada inválida. Digite apenas números.");
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        labelResultado.setText("Resultado: Erro");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
