package vendingmachine;
/**
 * This class can be a singleton
 * */
public class VendingMachine {

    private static VendingMachine machine;
    private MachineState idleState;
    private MachineState readyState;
    private MachineState dispenseState;
    private MachineState collectState;
    private MachineState currentState;
    private Inventory inventory;
    private Product selectedProduct;

    private double totalCost;


    private VendingMachine(){
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.collectState = new CollectState(this);
        this.currentState = idleState;
        this.inventory = new Inventory();
        this.totalCost = 0.0;
    }

    public static VendingMachine getInstance(){
        if(machine==null){
            machine = new VendingMachine();
            return machine;
        }
        return machine;
    }

    public Product addProduct(String name, double cost, int quantity){
        Product p = new Product(name,cost);
        inventory.addNewProduct(p, quantity);
        return p;
    }

    public void insertCoin(Coin coin){
        this.currentState.insertCoin(coin);
    }

    public void insertNote(Note note){
        this.currentState.insertNote(note);
    }

    void addCoin(Coin coin) {
        totalCost += coin.getValue();
    }

    void addNote(Note note) {
        totalCost += note.getValue();
    }

    void dispenseProduct() {
        this.currentState.dispenseProduct();
    }

    void returnChange(){
        this.currentState.collectCoins();
    }

    void selectProduct(Product p){
        this.currentState.selectProduct(p);
    }


    public double getTotalCost() {
        return totalCost;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public MachineState getReadyState() {
        return readyState;
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }

    public MachineState getCollectState() {
        return collectState;
    }

    public void setMachineState(MachineState state){
        this.currentState = state;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void dispenseProduct(Product product) {
        int quantity = inventory.getQuantity(product);
        inventory.updateQuantity(product, quantity-1);
        System.out.println("Quantity for product has been updated to "+(quantity-1));
    }

    public void resetSelectedProduct() {
        this.selectedProduct = null;
    }

    public void resetTotalCost() {
        this.setTotalCost(0.0);
    }
}
