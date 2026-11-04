import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollmentFeeCalculator extends JFrame {

    private JTextField txtStudentName;
    private JTextField txtUnits;

    private JRadioButton rbRegular;
    private JRadioButton rbScholar;
    private ButtonGroup studentGroup;

    private JCheckBox cbLibrary;
    private JCheckBox cbLab;

    private JTextArea txtReceipt;
    private JLabel lblStatus;

    private JButton btnCalculate;
    private JButton btnClear;
    private JButton btnExit;

    private final FeeService feeService;

    public EnrollmentFeeCalculator() {
        feeService = new FeeService();

        setTitle("University Enrollment Fee Calculator");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Student information panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(
                BorderFactory.createTitledBorder("Student Information")
        );

        txtStudentName = new JTextField();
        txtUnits = new JTextField();

        rbRegular = new JRadioButton("Regular", true);
        rbScholar = new JRadioButton("Scholar");

        studentGroup = new ButtonGroup();
        studentGroup.add(rbRegular);
        studentGroup.add(rbScholar);

        JPanel studentTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        studentTypePanel.add(rbRegular);
        studentTypePanel.add(rbScholar);

        cbLibrary = new JCheckBox("Library Fee (PHP 50)");
        cbLab = new JCheckBox("Lab Fee (PHP 75)");

        JPanel optionalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        optionalPanel.add(cbLibrary);
        optionalPanel.add(cbLab);

        inputPanel.add(new JLabel("Student Name:"));
        inputPanel.add(txtStudentName);
        inputPanel.add(new JLabel("Number of Units:"));
        inputPanel.add(txtUnits);
        inputPanel.add(new JLabel("Student Type:"));
        inputPanel.add(studentTypePanel);
        inputPanel.add(new JLabel("Optional Fees:"));
        inputPanel.add(optionalPanel);

        add(inputPanel, BorderLayout.NORTH);

        // Receipt panel
        txtReceipt = new JTextArea();
        txtReceipt.setEditable(false);
        txtReceipt.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(txtReceipt);
        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Enrollment Receipt")
        );
        add(scrollPane, BorderLayout.CENTER);

        // Buttons and status
        btnCalculate = new JButton("Calculate Fee");
        btnClear = new JButton("Clear / Reset");
        btnExit = new JButton("Exit");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        lblStatus = new JLabel("Ready. Enter student information.");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(lblStatus, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // 1. Named ActionListener for Calculate
        btnCalculate.addActionListener(new CalculateListener());

        // 2. Anonymous inner class for Clear / Reset
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtStudentName.setText("");
                txtUnits.setText("");
                rbRegular.setSelected(true);
                cbLibrary.setSelected(false);
                cbLab.setSelected(false);
                txtReceipt.setText("");
                lblStatus.setText("Ready. Enter student information.");
            }
        });

        // 3. Lambda expression for Exit
        btnExit.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    EnrollmentFeeCalculator.this,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Named listener for the Calculate button
    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtReceipt.setText("");

            String studentName = txtStudentName.getText();
            String unitsInput = txtUnits.getText();

            boolean isScholar = rbScholar.isSelected();
            boolean hasLibrary = cbLibrary.isSelected();
            boolean hasLab = cbLab.isSelected();

            try {
                double total = feeService.calculateFee(
                        studentName,
                        unitsInput,
                        isScholar,
                        hasLibrary,
                        hasLab
                );

                int units = Integer.parseInt(unitsInput.trim());

                double tuition = units * 500.00;
                double discount = isScholar ? tuition * 0.20 : 0.00;
                double libraryFee = hasLibrary ? 50.00 : 0.00;
                double labFee = hasLab ? 75.00 : 0.00;

                StringBuilder receipt = new StringBuilder();

                receipt.append("====================================\n");
                receipt.append("       UNIVERSITY ENROLLMENT\n");
                receipt.append("              RECEIPT\n");
                receipt.append("====================================\n\n");

                receipt.append("Student Name : ")
                        .append(studentName.trim()).append("\n");
                receipt.append("Units        : ").append(units).append("\n");
                receipt.append("Student Type : ")
                        .append(isScholar ? "Scholar" : "Regular")
                        .append("\n");

                receipt.append("\n------------------------------------\n");
                receipt.append("              FEE DETAILS\n");
                receipt.append("------------------------------------\n");

                receipt.append(String.format(
                        "Tuition       : PHP %,.2f%n", tuition));
                receipt.append(String.format(
                        "Discount      : PHP %,.2f%n", discount));
                receipt.append(String.format(
                        "Library Fee   : PHP %,.2f%n", libraryFee));
                receipt.append(String.format(
                        "Lab Fee       : PHP %,.2f%n", labFee));

                receipt.append("------------------------------------\n");
                receipt.append(String.format(
                        "TOTAL         : PHP %,.2f%n", total));
                receipt.append("====================================\n");
                receipt.append("       Thank you for enrolling!\n");

                txtReceipt.setText(receipt.toString());
                lblStatus.setText("Calculation successful!");

            } catch (InvalidStudentNameException |
                     InvalidUnitsException ex) {

                JOptionPane.showMessageDialog(
                        EnrollmentFeeCalculator.this,
                        ex.getMessage(),
                        "Input Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );

                lblStatus.setText("Please correct the invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnrollmentFeeCalculator());
    }
}
