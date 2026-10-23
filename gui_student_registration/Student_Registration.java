
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Student_Registration extends JFrame {

    private JTextField txtName, txtID;
    private JComboBox<String> cmbCourse;
    private JRadioButton rbMale, rbFemale;
    private JButton btnSubmit;

    public Student_Registration() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel using GridLayout
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Student Name
        panel.add(new JLabel("Student Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        // Student ID
        panel.add(new JLabel("Student ID:"));
        txtID = new JTextField();
        panel.add(txtID);

        // Course Selection
        panel.add(new JLabel("Course:"));
        String[] courses = {
            "BSIT", "BSCS", "BSBA", "BSED", "BSHM"
        };
        cmbCourse = new JComboBox<>(courses);
        panel.add(cmbCourse);

        // Gender Selection
        panel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        panel.add(genderPanel);

        // Submit Button
        panel.add(new JLabel(""));
        btnSubmit = new JButton("Submit");
        panel.add(btnSubmit);

        // Submit button event
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String id = txtID.getText().trim();
                String course = (String) cmbCourse.getSelectedItem();

                String gender = "";
                if (rbMale.isSelected()) {
                    gender = "Male";
                } else if (rbFemale.isSelected()) {
                    gender = "Female";
                }

                if (name.isEmpty() || id.isEmpty()
                        || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        Student_Registration.this,
                        "Please complete all fields.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                String message =
                    "STUDENT REGISTRATION DETAILS\n\n"
                    + "Name: " + name + "\n"
                    + "Student ID: " + id + "\n"
                    + "Course: " + course + "\n"
                    + "Gender: " + gender;

                JOptionPane.showMessageDialog(
                    Student_Registration.this,
                    message,
                    "Registration Successful",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Student_Registration().setVisible(true);
        });
    }
}
