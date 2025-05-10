package vendingmachine;

public class CollectState implements MachineState{

    private VendingMachine machine;

    CollectState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void selectProduct(Product p) {
        System.out.println("Please collect your change first!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please collect your change first!");
    }

    @Override
    public void collectCoins() {
        double totalCost = machine.getTotalCost();
        double costPrice = machine.getSelectedProduct().getPrice();
        if(totalCost>costPrice){
            double res = totalCost - costPrice;
            System.out.println("Returned change of "+res);
        } else {
            System.out.println("No change to return");
        }
        machine.resetSelectedProduct();
        machine.resetTotalCost();
        machine.setMachineState(machine.getIdleState());
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect your change first!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect your change first!");
    }
}
