package stackoverflow;

public class Tag {
    private final String name;
    private final int id;
    public Tag(String t) {
        this.name = t;
        this.id = setId();
    }

    private int setId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getName() {
        return name;
    }
}
