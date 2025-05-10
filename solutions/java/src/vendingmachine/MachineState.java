package vendingmachine;

public interface MachineState {
    void selectProduct(Product p);
    void dispenseProduct();
    void collectCoins();
    void insertCoin(Coin coin);
    void insertNote(Note note);
}
