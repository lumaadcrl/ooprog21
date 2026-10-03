package online_shopping_system;

public class Main {
    public static void main(String[] args) {

        Product clothes = new Clothes("C001", "T-Shirt", "M", "Blue", "Cotton", "Nike", 19.99);
        Product electronics = new Electronics("E001", "Smartphone", "Apple", "iPhone 12", "6.1-inch Display, 128GB Storage", "2 Years", "Black", 499.99);

        System.out.println("Clothes Details:");
        clothes.displayClothesDetails();

        System.out.println("\nElectronics Details:");
        electronics.displayElectronicsDetails();
    }   
}
