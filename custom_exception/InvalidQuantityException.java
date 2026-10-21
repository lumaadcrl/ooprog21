public class InvalidQuantityException extends RuntimeException {
    
    public InvalidQuantityException(String message) {
        super(message);
    }
}








public class InventoryItem {
    private String productName;
    private int stock;

   
    public InventoryItem(String productName, int stock) {
        this.productName = productName;
        this.stock = stock;
    }

    
    public void orderItem(int amount) {
        if (amount <= 0) {
            throw new InvalidQuantityException("Invalid order: Quantity must be greater than zero.");
        }
        if (amount > stock) {
            throw new InvalidQuantityException("Invalid order: Not enough stock available.");
        }
        
        
        stock -= amount;
        System.out.println("Order successful!");
    }

    
    public void displayStock() {
        System.out.println("Product: " + productName);
        System.out.println("Available Stock: " + stock);
    }

    
    public void displayRemainingStock() {
        System.out.println("Remaining Stock: " + stock);
    }
}









public class CustomExepMainFile {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Inventory Management System Test ===");
        System.out.println();

    
        runTest(1, 10, 3);
        runTest(2, 7, 7);
        runTest(3, 10, 0);
        runTest(4, 10, -2);
        runTest(5, 10, 15);
        runTest(6, 10, 10);
    }

   
    public static void runTest(int testNum, int initialStock, int orderQty) {
        System.out.println("--- Test Case " + testNum + " ---");
        InventoryItem item = new InventoryItem("Wireless Mouse", initialStock);
        item.displayStock();
        
        try {
            System.out.println("Ordering " + orderQty + " item(s)...");
            item.orderItem(orderQty);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }
        
        item.displayRemainingStock();
        System.out.println();
    }
}