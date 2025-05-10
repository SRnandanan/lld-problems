package vendingmachine;

public class ReadyState implements MachineState{

    private VendingMachine machine;

    ReadyState(VendingMachine machine) {
        this.machine = machine;
    }
    @Override
    public void selectProduct(Product p) {
        System.out.println("Product has already been selected, please pay");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment to dispense product!");
    }

    @Override
    public void collectCoins() {
        System.out.println("Please make payment to dispense change");
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addCoin(coin);
        System.out.println("Added coin");
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        machine.addNote(note);
        System.out.println("Added note");
        checkPaymentStatus();
    }

    private void checkPaymentStatus(){
        if(machine.getTotalCost()<machine.getSelectedProduct().getPrice()){
            System.out.println("Please add more currency");
        }else{
            machine.setMachineState(machine.getDispenseState());
        }
    }
}
