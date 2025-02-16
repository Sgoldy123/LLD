package VendingMachine;
import VendingMachine.POJO.Product;
import VendingMachine.POJO.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Add products to the vending machine
        vendingMachine.getInventory().addProduct(new Product(1, "Soda", 50), 5);
        vendingMachine.getInventory().addProduct(new Product(2, "Chips", 30), 10);
        vendingMachine.getInventory().addProduct(new Product(3, "Chocolate", 40), 2);

        // Simulate operations
        vendingMachine.pressButton(1); // No coin inserted
        vendingMachine.insertCoin();  // Insert coin
        vendingMachine.pressButton(1); // Select product
        vendingMachine.dispense();   // Dispense product

        vendingMachine.insertCoin();  // Insert coin
        vendingMachine.pressButton(2); // Select another product
        vendingMachine.dispense();   // Dispense product
    }
}
