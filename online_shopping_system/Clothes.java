package online_shopping_system;

public class Clothes extends Product {

    private String size;
    private String color;
    private String material;
    private String brand;

    Clothes(String productId, String name, String size, String color, String material, String brand, double price) {
        super(productId, name, price);
        this.size = size;
        this.color = color;
        this.material = material;
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double calculatePrice() {
        return getPrice();
    }

    public void displayClothesDetails() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
        System.out.println("Brand: " + brand);
    }

}
