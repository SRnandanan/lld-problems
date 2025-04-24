package parkinglotsanjay;

import parkinglotsanjay.vehicletypes.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot {

    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static ParkingLot createInstance(){
        if(instance==null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level l){
        this.levels.add(l);
    }

    public boolean parkVehicle(Vehicle v){
        for(Level level: levels){
            if(level.parkVehicle(v)){
                return true;
            }
        }
        System.out.println("Unable to park vehicle "+ v.getPlate());
        return false;

    }

    public boolean unparkVehicle(Vehicle v){
        for(Level level: levels){
            if(level.unparkVehicle(v)){
                return true;
            }
        }
        System.out.println("Unable to unpark vehicle "+ v.getPlate());
        return false;
    }

    public void getAvailability(){
        for(Level l: levels){
            l.getAvailability();
        }
    }

}
