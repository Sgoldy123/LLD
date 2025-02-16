package VendingMachine.State;
import VendingMachine.POJO.VendingMachine;

// State interface
public interface State {
    void insertCoin(VendingMachine vendingMachine);
    void pressButton(VendingMachine vendingMachine, int productCode);
    void dispense(VendingMachine vendingMachine);
}
