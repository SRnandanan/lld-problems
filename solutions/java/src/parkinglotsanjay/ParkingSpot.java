package parkinglotsanjay;

import parkinglotsanjay.vehicletypes.Vehicle;
import parkinglotsanjay.vehicletypes.VehicleType;

public class ParkingSpot {
    private final int id;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public void enter(Vehicle v){
        if(isAvailable() && getVehicleType().equals(v.getType())){
            this.setParkedVehicle(v);
        } else {
            throw new IllegalArgumentException("Unable to park the vehicle");
        }

    }

    public void exit(){
        this.setParkedVehicle(null);
    }

    public int getId() {
        return id;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public boolean isAvailable(){
        return parkedVehicle == null;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", parkedVehicle=" + parkedVehicle +
                '}';
    }
}
