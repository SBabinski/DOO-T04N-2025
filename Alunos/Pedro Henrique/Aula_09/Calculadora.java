import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {
    private JTextField campo1;
    private JTextField campo2;
    private JLabel resultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(320, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 5, 5));
        getContentPane().setBackground(new Color(40, 44, 52));

        campo1 = criarCampoTexto();
        campo2 = criarCampoTexto();

        resultado = new JLabel("Resultado: ");
        resultado.setFont(new Font("Arial", Font.BOLD, 16));
        resultado.setForeground(new Color(173, 216, 230));
        resultado.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 5, 5, 5));
        painelBotoes.setBackground(new Color(40, 44, 52));

        // Botões com fundo claro e texto preto para visibilidade
        JButton soma = criarBotao("+");
        JButton subtrai = criarBotao("-");
        JButton multiplica = criarBotao("×");
        JButton divide = criarBotao("÷");
        JButton limpar = criarBotao("C");

        soma.addActionListener(e -> calcular('+'));
        subtrai.addActionListener(e -> calcular('-'));
        multiplica.addActionListener(e -> calcular('*'));
        divide.addActionListener(e -> calcular('/'));
        limpar.addActionListener(e -> {
            campo1.setText("");
            campo2.setText("");
            resultado.setText("Resultado: ");
        });

        painelBotoes.add(soma);
        painelBotoes.add(subtrai);
        painelBotoes.add(multiplica);
        painelBotoes.add(divide);
        painelBotoes.add(limpar);

        add(criarLabel("Primeiro número:"));
        add(campo1);
        add(criarLabel("Segundo número:"));
        add(campo2);
        add(painelBotoes);
        add(resultado);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextField criarCampoTexto() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        campo.setBackground(new Color(60, 63, 65));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        return campo;
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(new Color(220, 220, 220)); // Fundo claro
        botao.setForeground(Color.BLACK);              // Texto preto
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }

    private void calcular(char operacao) {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double res;

            switch (operacao) {
                case '+': res = num1 + num2; break;
                case '-': res = num1 - num2; break;
                case '*': res = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this,
                            "Não é possível dividir por zero.",
                            "Erro de Cálculo",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    res = num1 / num2;
                    break;
                default:
                    JOptionPane.showMessageDialog(this,
                        "Operação inválida.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                    return;
            }

            resultado.setText("Resultado: " + res);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Entrada inválida! Digite apenas números.",
                "Erro de Entrada",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        new Calculadora();
    }
}
