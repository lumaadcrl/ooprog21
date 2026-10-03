package university_payment_system;

public abstract class Payment {
    
    private String paymentId;
    private String studentId;
    private String studentName;
    private double amount;

    public Payment(String paymentId, String studentId, String studentName, double amount) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment();
}
