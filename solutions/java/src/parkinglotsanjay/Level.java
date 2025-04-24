package parkinglotsanjay;

import parkinglotsanjay.vehicletypes.Vehicle;
import parkinglotsanjay.vehicletypes.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private List<ParkingSpot> spots;

    private int floor;

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Level(int floor, int s){
        this.floor = floor;
        this.spots = new ArrayList<>(s);
        // assign 60:30:10 for bike, car and trucks;
        int bikeEnd = (int) (0.6*s);
        int carEnd = bikeEnd + (int) (0.3*s);
        int truckEnd = carEnd + (int) (0.1*s);
        for(int i=0; i<=bikeEnd; i++){
            spots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for(int i=bikeEnd+1; i<=carEnd; i++){
            spots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i=carEnd+1; i<truckEnd; i++) {
            spots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }

    }

    public boolean parkVehicle(Vehicle v){
        for(ParkingSpot spot: spots){
            if(spot.getVehicleType().equals(v.getType()) && spot.isAvailable()){
                spot.enter(v);
                System.out.println("Parked at spot "+ spot.toString());
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle v){
        for(ParkingSpot spot: spots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(v)){
                spot.exit();
                System.out.println("Spot "+ spot.getId()+ " is now available");
                return true;
            }
        }

        return false;
    }

    public void getAvailability(){
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : spots) {
            System.out.println("Spot " + spot.getId() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }
}
