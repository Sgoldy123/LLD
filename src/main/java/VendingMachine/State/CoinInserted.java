package VendingMachine.State;
import  VendingMachine.POJO.VendingMachine;

public class CoinInserted implements State {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin already inserted. Please press the button to select a product.");
    }

    @Override
    public void pressButton(VendingMachine vendingMachine, int productCode) {
        if (vendingMachine.getInventory().isProductAvailable(productCode)) {
            System.out.println("Product selected. Dispensing product...");
            vendingMachine.setState(new Dispensing());
            vendingMachine.getInventory().reduceProductQuantity(productCode);
        } else {
            System.out.println("Product is out of stock. Returning coin.");
            vendingMachine.setState(new NoCoinInserted());
        }
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Press a button to select a product first!");
    }
}
