package university_payment_system;

public class LaboratoryPayment extends Payment {
    
    private String labName;

    public LaboratoryPayment(String paymentId, String studentId, String studentName, double amount, String labName) {
        super(paymentId, studentId, studentName, amount);
        this.labName = labName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    @Override
    public void processPayment() {
        // Implement the logic to process laboratory payment
        System.out.println("\nLaboratory payment processed for student ID: " + getStudentId());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Lab Name: " + labName);
        System.out.println("Amount: $" + getAmount());
    }
    
}
