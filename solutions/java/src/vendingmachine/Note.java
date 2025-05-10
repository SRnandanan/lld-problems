package vendingmachine;

public enum Note {
    FIVE(5),
    TEN(10),
    TWENTY(20),
    HUNDRED(100);

    private final int value;

    Note(int val){
        this.value = val;
    }

    public int getValue(){
        return this.value;
    }

}
