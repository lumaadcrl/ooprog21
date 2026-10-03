package university_payment_system;

public class TuitionPayment extends Payment {
    
    private String semester;

    public TuitionPayment(String paymentId, String studentId, String studentName, double amount, String semester) {
        super(paymentId, studentId, studentName, amount);
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    double calculateDiscountedAmount() {
        double discount = getAmount() * (discountPercentage() / 100);
        return getAmount() - discount;
    }

    public double discountPercentage() {
        return 3.0; // Default discount percentage for tuition payments
    }

    @Override
    public void processPayment() {
        // Implement the logic to process tuition payment
        System.out.println("\nTuition payment processed for student ID: " + getStudentId());
        System.out.println("Student Name: " + getStudentName());    
        System.out.println("Semester: " + semester);
        System.out.println("Original Amount: $" + getAmount());
        System.out.println("Discount Percentage: " + discountPercentage() + "%");
        System.out.println("Discounted Amount: $" + calculateDiscountedAmount());
                           
    }
    
}
