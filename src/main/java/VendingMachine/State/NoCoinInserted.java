package VendingMachine.State;
import VendingMachine.POJO.VendingMachine;

public class NoCoinInserted implements State {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin inserted successfully.");
        vendingMachine.setState(new CoinInserted());
    }

    @Override
    public void pressButton(VendingMachine vendingMachine, int productCode) {
        System.out.println("You need to insert a coin first!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Insert a coin first to dispense the product.");
    }
}
