package vendingmachine;

public enum Coin {

    QUARTER(0.25),
    HALF(0.5),
    FULL(1);

    private final double value;

    Coin(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }




}
