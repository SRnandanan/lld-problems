package parkinglotsanjay.vehicletypes;

public abstract class Vehicle {
    protected VehicleType type;
    protected String plate;

    public Vehicle(VehicleType t, String p){
        this.type = t;
        this.plate = p;
    }

    public String getPlate() {
        return plate;
    }

    public VehicleType getType() {
        return type;
    }
}
