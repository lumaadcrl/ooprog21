package university_payment_system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Payment> payments = new ArrayList<>();
                
        System.out.println("Welcome to the University Payment System!");
        System.out.println("Please select the type of payment:");
        System.out.println("1. Tuition Payment");   
        System.out.println("2. Laboratory Payment");
        System.out.print("Enter your choice (1 or 2):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println();

        if (choice == 1) {
            System.out.print("Enter Payment ID: ");
            String paymentId = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Semester: ");
            String semester = scanner.nextLine();

            TuitionPayment tuitionPayment = new TuitionPayment(paymentId, studentId, studentName, amount, semester);
            payments.add(tuitionPayment);
            tuitionPayment.processPayment();
        } else if (choice == 2) {
            System.out.print("Enter Payment ID: ");
            String paymentId = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Lab Name: ");
            String labName = scanner.nextLine();

            LaboratoryPayment laboratoryPayment = new LaboratoryPayment(paymentId, studentId, studentName, amount, labName);
            payments.add(laboratoryPayment);
            laboratoryPayment.processPayment();
        } else {
            System.out.println("Invalid choice. Please restart the program and select a valid option.");

        }

    }
}
