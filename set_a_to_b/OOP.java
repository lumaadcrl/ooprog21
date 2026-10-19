package set_a_to_b;

import java.util.ArrayList;

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

    }
}
