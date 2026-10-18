package gui_sum_of_two_numbers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Numbers extends JFrame implements ActionListener {

    private final JTextField num1Field;
    private final JTextField num2Field;
    private final JButton sumButton;
    private final JButton clearButton;

    Numbers() {
        ImageIcon image = new ImageIcon("gui_sum_of_two_numbers/summation.png");
        this.setIconImage(image.getImage());
    
        this.setTitle("Sum of Two Numbers");
        this.setSize(350, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JLabel num1Label = new JLabel("Number 1 ");
        num1Label.setFont(new Font("Inter", Font.PLAIN, 15));
        num1Label.setBounds(20, 40, 100, 20);

        num1Field = new JTextField();
        num1Field.setBounds(100, 40, 210, 30);

        JLabel num2Label = new JLabel("Number 2");
        num2Label.setFont(new Font("Inter", Font.PLAIN, 15));
        num2Label.setBounds(20, 80, 100, 20);

        num2Field = new JTextField();
        num2Field.setBounds(100, 80, 210, 30);

        sumButton = new JButton("Calculate");
        sumButton.setBounds(100, 130, 100, 30);
        sumButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setBounds(210, 130, 100, 30);
        clearButton.addActionListener(this);

        this.add(num1Label);
        this.add(num2Label);
        this.add(num1Field);
        this.add(num2Field);
        this.add(sumButton);
        this.add(clearButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sumButton) {
            try {
                double num1 = Double.parseDouble(
                    num1Field.getText()
                );

                double num2 = Double.parseDouble(
                    num2Field.getText()
                );

                double sum = num1 + num2;
                JOptionPane.showMessageDialog(
                    this,
                    "Sum: " + sum,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
        }
    }
    
}
