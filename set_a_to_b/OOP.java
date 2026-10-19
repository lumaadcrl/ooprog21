package set_a_to_b;

import java.util.ArrayList;

import set_a_to_b.OOP.Employee;

public class OOP {

    // SET A
    enum Category{
        FICTION, SCIENCE, HISTORY
    }

    class Book{
        private String title;
        private Category category;

        Book(String title, Category category){
            this.title = title;
            this.category = category;
        }

        void setTitle(String title){
            this.title = title;
        }

        void displayInfo(){
            System.out.println("Title: " + title + " | Category: " + category);
        }

        void addingInfo(){
            ArrayList<Book> books = new ArrayList<>();

            books.add(new Book("The River", Category.FICTION));
            books.add(new Book("Space Science", Category.SCIENCE));
            books.add(new Book("World History", Category.HISTORY));

            books.get(1).setTitle("Basic Space Science");
            books.remove(0);

            for(Book book: books){
                book.displayInfo();
            }

            System.out.println("Total Books: " + books.size());
        }
    }

    // SET B
    enum Level {
        FIRST, SECOND, THIRD
    }

    class Student {
        private String name;
        private Level level;

        Student(String name, Level level){
            this.name = name;
            this.level = level;
        }

        void setName(String name){
            this.name = name;
        }

        void displayInfo(){
            System.out.println("Name: " + name + " | Level: " + level);
        }

        void addingInfo(){
            ArrayList<Student> students = new ArrayList<>();

            students.add(new Student("Anna", Level.FIRST));
            students.add(new Student("Ben", Level.SECOND));
            students.add(new Student("Cara", Level.THIRD));

            students.get(0).setName("Anna");
            students.remove(2);

            for(Student student: students){
                student.displayInfo();
            }

            System.out.println("Total Students: " + students.size());
        }
    }

    // SET C
    enum Status {
        PENDING, READY, SERVED
    }

    class Order {
        private String item;
        private Status status;

        Order(String item, Status status){
            this.item = item;
            this.status = status;
        }

        void setStatus(Status status){
            this.status = status;
        }

        void displayInfo(){
            System.out.println("Item: " + item + " | Status: " + status);
        }

        void addingInfo(){
            ArrayList<Order> orders = new ArrayList<>();

            orders.add(new Order("Burger", Status.PENDING));
            orders.add(new Order("Pizza", Status.READY));
            orders.add(new Order("Pasta", Status.SERVED));

            orders.get(1).setStatus(Status.SERVED);
            orders.remove(0);

            for(Order order: orders){
                order.displayInfo();
            }

            System.out.println("Total Orders: " + orders.size());
        }
    }

    // SET D
    enum EventType {
        SPORTS, MUSIC, ACADEMIC
    }
    class Event{
        private String name;
        private EventType eventType;

        Event(String name, EventType eventType){
            this.name = name;
            this.eventType = eventType;
        }

        void setName(String name){
            this.name = name;
        }

        void displayInfo(){
            System.out.println("Event Name: " + name + " | Event Type: " + eventType);
        }

        void addingInfo(){
            ArrayList<Event> events = new ArrayList<>();

            events.add(new Event("Basketball Game", EventType.SPORTS));
            events.add(new Event("Campus Concert", EventType.MUSIC));
            events.add(new Event("Java Seminar", EventType.ACADEMIC));

            events.get(1).setName("University Concert");
            events.remove(0);

            for(Event event: events){
                event.displayInfo();
            }

            System.out.println("Total Events: " + events.size());
        }
    }

    // SET E
    enum Department{
        IT, HR, SALES
    }
    class Employee{
        private String name;
        private Department department;

        Employee(String name, Department department){
            this.name = name;
            this.department = department;
        }

        void setName(String name){
            this.name = name;
        }

        void displayInfo(){
            System.out.println("Name: " + name + " | Department: " + department);
        }

        void addingInfo(){
            ArrayList<Employee> employees = new ArrayList<>();

            employees.add(new Employee("Leo", Department.IT));
            employees.add(new Employee("Mia", Department.HR));
            employees.add(new Employee("Noah", Department.SALES));

            employees.get(2).setName("Nathan");
            employees.remove(0);

            for(Employee employee: employees){
                employee.displayInfo();
            }

            System.out.println("Total Employee: " + employees.size());
        }        

    }

    // SET F
    enum ProductType{
        FOOD, CLOTHINGS, ELECTRONICS
    }

    class Product{
        private String name;
        private ProductType type;

        Product(String name, ProductType type){
            this.name = name;
            this.type = type;
        }

        void setName(String name){
            this.name = name;
        }

        void displayInfo(){
            System.out.println("Product: " + name + " | Type: " + type);
        }

        void addingInfo(){
            ArrayList<Product> products = new ArrayList<>();

            products.add(new Product("Bread", ProductType.FOOD));
            products.add(new Product("Jacket", ProductType.CLOTHINGS));
            products.add(new Product("Headphones", ProductType.ELECTRONICS));

            products.get(0).setName("Whole Wheat Bread");
            products.remove(2);

            for(Product product: products){
                product.displayInfo();
            }

            System.out.println("Total Employee: " + products.size());
        }  
    }

    public static void main(String[] args) {

        // SET A
        System.out.println("----- SET A -----");
        OOP oop = new OOP();
        Book book = oop.new Book("The River", Category.FICTION);
        book.addingInfo();

        System.out.println();

        // SET B
        System.out.println("----- SET B -----");
        OOP oop2 = new OOP();
        Student student = oop2.new Student("Anna", Level.FIRST);
        student.addingInfo();

        System.out.println();

        // SET C
        System.out.println("----- SET C -----");
        OOP oop3 = new OOP();
        Order order = oop3.new Order("Burger", Status.READY);
        order.addingInfo();

        System.out.println();

        // SET D
        System.out.println("----- SET D -----");
        OOP oop4 = new OOP();
        Event event = oop4.new Event("Basketball Game", EventType.SPORTS);
        event.addingInfo();

        System.out.println();

        // SET E
        System.out.println("----- SET E -----");
        OOP oop5 = new OOP();
        Employee employee = oop5.new Employee("Nathan", Department.SALES);
        employee.addingInfo();

        System.out.println();

        // SET F
        System.out.println("----- SET F -----");
        OOP oop6 = new OOP();
        Product product = oop6.new Product("Jacket", ProductType.CLOTHINGS);
        product.addingInfo();
    }
}
