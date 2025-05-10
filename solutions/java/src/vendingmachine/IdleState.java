package vendingmachine;

public class IdleState implements MachineState{

    private VendingMachine machine;

    public IdleState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void selectProduct(Product p) {
        if(!machine.getInventory().isProductAvailable(p)){
            System.out.println("Product is not available!");
        }else {
            machine.setSelectedProduct(p);
            machine.setMachineState(machine.getReadyState());
        }

    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a Product");
    }

    @Override
    public void collectCoins() {
        System.out.println("No change available");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product");
    }
}
