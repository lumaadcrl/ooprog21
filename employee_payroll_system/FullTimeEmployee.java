public class FullTimeEmployee extends Employee {

    private double bonus;

    FullTimeEmployee(String employeeId, String name, String department, double salary, double bonus) {
        super(employeeId, name, department, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculatePay() {
        return getSalary() + bonus;
    }

    public void showEmployeeDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Salary: " + getSalary());
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Pay: " + calculatePay());
    }
    
}
