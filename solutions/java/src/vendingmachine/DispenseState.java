package vendingmachine;

public class DispenseState implements MachineState{
    private VendingMachine machine;

    DispenseState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void selectProduct(Product p) {
        System.out.println("Dispensing product please wait");
    }

    @Override
    public void dispenseProduct() {
        machine.dispenseProduct(machine.getSelectedProduct());
        System.out.println("Dispensed product "+machine.getSelectedProduct());
        machine.setMachineState(machine.getCollectState());
    }

    @Override
    public void collectCoins() {
        System.out.println("Dispensing product please wait");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Dispensing product please wait");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Dispensing product please wait");
    }
}
