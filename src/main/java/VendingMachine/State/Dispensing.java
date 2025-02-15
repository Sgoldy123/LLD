package VendingMachine.State;
import VendingMachine.POJO.VendingMachine;

public class Dispensing implements State {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Dispensing in progress. Please wait...");
    }

    @Override
    public void pressButton(VendingMachine vendingMachine, int productCode) {
        System.out.println("Dispensing in progress. Please wait...");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Product dispensed. Thank you!");
        vendingMachine.setState(new NoCoinInserted());
    }
}
