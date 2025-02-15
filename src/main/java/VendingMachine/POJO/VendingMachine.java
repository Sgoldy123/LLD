package VendingMachine.POJO;

import VendingMachine.State.NoCoinInserted;
import VendingMachine.State.State;

public class VendingMachine {
    private State state;
    private Inventory inventory;

    public VendingMachine() {
        this.state = new NoCoinInserted();
        this.inventory = new Inventory();
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void pressButton(int productCode) {
        state.pressButton(this, productCode);
    }

    public void dispense() {
        state.dispense(this);
    }
}
