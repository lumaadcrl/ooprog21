package online_shopping_system;

public class Electronics  extends Product {

    private String brand;
    private String model;
    private String specifications;
    private String warranty;
    private String color;
    
    Electronics(String productId, String name, String brand, String model, String specifications, String warranty, String color, double price) {
        super(productId, name, price);
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.warranty = warranty;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calculatePrice() {
        return getPrice();
    }

    public void displayElectronicsDetails() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Specifications: " + specifications);
        System.out.println("Warranty: " + warranty);
        System.out.println("Color: " + color);
    }
    
}
