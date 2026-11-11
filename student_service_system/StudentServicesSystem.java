
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ==========================================
// CUSTOM EXCEPTIONS
// ==========================================

// Checked Exception
class InvalidStudentNameException extends Exception {
    public InvalidStudentNameException(String message) {
        super(message);
    }
}

// Unchecked Exception
class InvalidUnitsException extends RuntimeException {
    public InvalidUnitsException(String message) {
        super(message);
    }
}

// Unchecked Exception
class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// ==========================================
// MAIN APPLICATION
// ==========================================

public class StudentServicesSystem extends JFrame {

    // Student Components
    JTextField txtName, txtID, txtUnits;
    JComboBox<String> cmbCourse;
    JRadioButton rbMale, rbFemale;
    JCheckBox cbLibrary, cbLaboratory;
    JComboBox<String> cmbStatus;
    JTextArea studentReceipt;

    // Inventory Components
    JTextField txtQuantity;
    JLabel lblStock;
    JTextArea inventoryReceipt;

    // Cafeteria Components
    JTextField txtBill;
    JTextArea cafeteriaReceipt;

    // Initial Stock
    int stock = 10;

    // Constructor
    public StudentServicesSystem() {

        setTitle("University Student Services and Transaction Management System");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Student Registration", createStudentPanel());
        tabs.addTab("Campus Store", createInventoryPanel());
        tabs.addTab("Cafeteria", createCafeteriaPanel());

        add(tabs);

        setVisible(true);
    }

    // ==========================================
    // 1. STUDENT REGISTRATION PANEL
    // ==========================================

    private JPanel createStudentPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(9, 2, 8, 8));

        form.setBorder(BorderFactory.createTitledBorder(
                "Student Registration and Enrollment"));

        txtName = new JTextField();
        txtID = new JTextField();
        txtUnits = new JTextField();

        cmbCourse = new JComboBox<>(new String[]{
            "BS Information Technology",
            "BS Computer Science",
            "BS Information Systems",
            "BS Business Administration",
            "BS Education"
        });

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        JPanel genderPanel = new JPanel();
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        cmbStatus = new JComboBox<>(new String[]{
            "Regular", "Scholar"
        });

        cbLibrary = new JCheckBox("Library Fee (PHP 50)");
        cbLaboratory = new JCheckBox("Laboratory Fee (PHP 75)");

        form.add(new JLabel("Student Name:"));
        form.add(txtName);

        form.add(new JLabel("Student ID:"));
        form.add(txtID);

        form.add(new JLabel("Course:"));
        form.add(cmbCourse);

        form.add(new JLabel("Gender:"));
        form.add(genderPanel);

        form.add(new JLabel("Number of Units (1-30):"));
        form.add(txtUnits);

        form.add(new JLabel("Student Status:"));
        form.add(cmbStatus);

        form.add(new JLabel("Additional Fees:"));

        JPanel fees = new JPanel();
        fees.add(cbLibrary);
        fees.add(cbLaboratory);

        form.add(fees);

        JButton btnCalculate = new JButton("Calculate Enrollment");
        JButton btnClear = new JButton("Clear");

        form.add(btnCalculate);
        form.add(btnClear);

        studentReceipt = new JTextArea(10, 40);
        studentReceipt.setEditable(false);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(studentReceipt), BorderLayout.CENTER);

        // NAMED ACTION LISTENER
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateEnrollment();
            }
        });

        // ANONYMOUS ACTION LISTENER
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtName.setText("");
                txtID.setText("");
                txtUnits.setText("");

                genderGroup.clearSelection();

                cmbCourse.setSelectedIndex(0);
                cmbStatus.setSelectedIndex(0);

                cbLibrary.setSelected(false);
                cbLaboratory.setSelected(false);

                studentReceipt.setText("");
            }
        });

        return panel;
    }

    // ==========================================
    // ENROLLMENT COMPUTATION
    // ==========================================

    private void calculateEnrollment() {

        try {

            String name = txtName.getText().trim();
            String id = txtID.getText().trim();

            if (name.isEmpty() || !name.matches("[\\p{L} .'-]+")) {
                throw new InvalidStudentNameException(
                        "Please enter a valid student name.");
            }

            if (id.isEmpty()) {
                throw new IllegalArgumentException(
                        "Student ID cannot be blank.");
            }

            if (!rbMale.isSelected() && !rbFemale.isSelected()) {
                throw new IllegalArgumentException(
                        "Please select a gender.");
            }

            int units = Integer.parseInt(txtUnits.getText().trim());

            if (units < 1 || units > 30) {
                throw new InvalidUnitsException(
                        "Units must be between 1 and 30.");
            }

            String gender = rbMale.isSelected() ? "Male" : "Female";
            String course = cmbCourse.getSelectedItem().toString();
            String status = cmbStatus.getSelectedItem().toString();

            double tuition = units * 500;
            double discount = 0;

            if (status.equals("Scholar")) {
                discount = tuition * 0.20;
            }

            double libraryFee = cbLibrary.isSelected() ? 50 : 0;
            double laboratoryFee = cbLaboratory.isSelected() ? 75 : 0;

            double total = tuition - discount
                    + libraryFee + laboratoryFee;

            studentReceipt.setText(
                    "========== ENROLLMENT RECEIPT ==========\n\n"
                    + "Student Name: " + name + "\n"
                    + "Student ID: " + id + "\n"
                    + "Course: " + course + "\n"
                    + "Gender: " + gender + "\n"
                    + "Units: " + units + "\n"
                    + "Status: " + status + "\n\n"
                    + "Tuition Fee: PHP " + String.format("%.2f", tuition) + "\n"
                    + "Scholar Discount: PHP " + String.format("%.2f", discount) + "\n"
                    + "Library Fee: PHP " + String.format("%.2f", libraryFee) + "\n"
                    + "Laboratory Fee: PHP " + String.format("%.2f", laboratoryFee) + "\n"
                    + "----------------------------------------\n"
                    + "TOTAL ENROLLMENT FEE: PHP "
                    + String.format("%.2f", total) + "\n"
                    + "========================================"
            );

            JOptionPane.showMessageDialog(this,
                    "Enrollment successfully calculated!");

        } catch (InvalidStudentNameException |
                 InvalidUnitsException ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Enrollment Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Enrollment Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ==========================================
    // 2. CAMPUS STORE INVENTORY PANEL
    // ==========================================

    private JPanel createInventoryPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));

        form.setBorder(BorderFactory.createTitledBorder(
                "Campus Store - Wireless Mouse"));

        lblStock = new JLabel("Available Stock: " + stock);

        txtQuantity = new JTextField();

        JButton btnOrder = new JButton("Place Order");
        JButton btnClear = new JButton("Clear");
        JButton btnExit = new JButton("Exit");

        form.add(new JLabel("Product:"));
        form.add(new JLabel("Wireless Mouse"));

        form.add(new JLabel("Available Inventory:"));
        form.add(lblStock);

        form.add(new JLabel("Order Quantity:"));
        form.add(txtQuantity);

        form.add(btnOrder);
        form.add(btnClear);

        inventoryReceipt = new JTextArea(10, 40);
        inventoryReceipt.setEditable(false);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(inventoryReceipt), BorderLayout.CENTER);
        panel.add(btnExit, BorderLayout.SOUTH);

        // LAMBDA ACTION LISTENER
        btnOrder.addActionListener(e -> processOrder());

        btnClear.addActionListener(e -> {
            txtQuantity.setText("");
            inventoryReceipt.setText("");
        });

        btnExit.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        return panel;
    }

    // ==========================================
    // INVENTORY TRANSACTION
    // ==========================================

    private void processOrder() {

        try {

            String input = txtQuantity.getText().trim();

            if (input.isEmpty()) {
                throw new InvalidQuantityException(
                        "Quantity cannot be blank.");
            }

            int quantity = Integer.parseInt(input);

            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero.");
            }

            if (quantity > stock) {
                throw new InvalidQuantityException(
                        "Insufficient inventory! Available stock: " + stock);
            }

            // Deduct stock only after validation
            stock -= quantity;

            lblStock.setText("Available Stock: " + stock);

            double price = 350.00;
            double total = quantity * price;

            inventoryReceipt.setText(
                    "========== STORE RECEIPT ==========\n\n"
                    + "Product: Wireless Mouse\n"
                    + "Quantity Ordered: " + quantity + "\n"
                    + "Unit Price: PHP " + String.format("%.2f", price) + "\n"
                    + "Total Amount: PHP " + String.format("%.2f", total) + "\n"
                    + "Remaining Inventory: " + stock + "\n"
                    + "==================================="
            );

            JOptionPane.showMessageDialog(this,
                    "Order successfully processed!");

        } catch (InvalidQuantityException ex) {

            JOptionPane.showMessageDialog(this,
                    "Invalid Order: " + ex.getMessage(),
                    "Inventory Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(this,
                    "Invalid Order: Please enter a valid numeric quantity.",
                    "Inventory Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ==========================================
    // 3. CAFETERIA PANEL
    // ==========================================

    private JPanel createCafeteriaPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));

        form.setBorder(BorderFactory.createTitledBorder(
                "Cafeteria Bill and Tip Calculator"));

        txtBill = new JTextField();

        JButton btn15 = new JButton("15 Percent Tip");
        JButton btn20 = new JButton("20 Percent Tip");
        JButton btnClear = new JButton("Clear");

        form.add(new JLabel("Bill Amount (PHP):"));
        form.add(txtBill);

        form.add(btn15);
        form.add(btn20);

        form.add(btnClear);

        cafeteriaReceipt = new JTextArea(10, 40);
        cafeteriaReceipt.setEditable(false);

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(cafeteriaReceipt), BorderLayout.CENTER);

        btn15.addActionListener(e -> calculateTip(0.15));
        btn20.addActionListener(e -> calculateTip(0.20));

        btnClear.addActionListener(e -> {
            txtBill.setText("");
            cafeteriaReceipt.setText("");
        });

        return panel;
    }

    // ==========================================
    // TIP COMPUTATION
    // ==========================================

    private void calculateTip(double percentage) {

        try {

            String input = txtBill.getText().trim();

            if (input.isEmpty()) {
                throw new IllegalArgumentException(
                        "Bill amount cannot be blank.");
            }

            double bill = Double.parseDouble(input);

            if (!Double.isFinite(bill) || bill < 0) {
                throw new IllegalArgumentException(
                        "Please enter a valid non-negative bill amount.");
            }

            double tip = bill * percentage;
            double total = bill + tip;

            cafeteriaReceipt.setText(
                    "========== CAFETERIA RECEIPT ==========\n\n"
                    + "Bill Amount: PHP " + String.format("%.2f", bill) + "\n"
                    + "Tip Percentage: " + (int)(percentage * 100) + "%\n"
                    + "Tip Amount: PHP " + String.format("%.2f", tip) + "\n"
                    + "---------------------------------------\n"
                    + "TOTAL AMOUNT: PHP " + String.format("%.2f", total) + "\n"
                    + "======================================="
            );

            JOptionPane.showMessageDialog(this,
                    "Bill successfully calculated!");

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(this,
                    "Invalid Bill: " + ex.getMessage(),
                    "Cafeteria Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new StudentServicesSystem();
        });

    }
}
