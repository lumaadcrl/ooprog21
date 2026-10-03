public class Main {
    public static void main(String[] args){

        Employee partime = new PartTimeEmployee("PT001", "John Doe", "Sales", 0, 20, 30);
        Employee fulltime = new FullTimeEmployee("FT001", "Jane Smith", "Marketing", 50000, 5000);

        System.out.println("Part-Time Employee Details:");
        ((PartTimeEmployee) partime).showEmployeeDetails();

        System.out.println("\nFull-Time Employee Details:");
        ((FullTimeEmployee) fulltime).showEmployeeDetails();
    }
}