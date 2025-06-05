import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Basica");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(4, 2)); 

        JLabel label1 = new JLabel("Digite o 1º número:");
        JTextField campo1 = new JTextField();

        JLabel label2 = new JLabel("Digite o 2º número:");
        JTextField campo2 = new JTextField();

        JLabel labelOperacao = new JLabel("Escolha a operação que deseja executar:");
        String[] operacoes = {"+", "-", "*", "/"};
        JComboBox<String> comboOperacao = new JComboBox<>(operacoes);

        JButton botaoCalcular = new JButton("Calcular");
        JLabel resultadoLabel = new JLabel("Resultado: ");

        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(campo1.getText());
                    double n2 = Double.parseDouble(campo2.getText());
                    String op = (String) comboOperacao.getSelectedItem();
                    double resultado = 0;

                    switch (op) {
                        case "+": resultado = n1 + n2; break;
                        case "-": resultado = n1 - n2; break;
                        case "*": resultado = n1 * n2; break;
                        case "/": resultado = n1 / n2; break;
                    }
                    if((n1 == 0 || n2 == 0) & op == "/") {
                        JOptionPane.showMessageDialog(frame,
                        "Não é possivel dividir por 0",
                        "calculo impossivel",
                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        resultadoLabel.setText("Resultado: " + resultado);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                    "Caracteres invalidos",
                    "Erro ao executar o calculo",
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panel.add(label1);
        panel.add(campo1);
        panel.add(label2);
        panel.add(campo2);
        panel.add(labelOperacao);
        panel.add(comboOperacao);
        panel.add(botaoCalcular);
        panel.add(resultadoLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
