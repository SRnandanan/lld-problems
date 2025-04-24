package parkinglotsanjay;

import parkinglotsanjay.vehicletypes.Bike;
import parkinglotsanjay.vehicletypes.Car;
import parkinglotsanjay.vehicletypes.Vehicle;
import parkinglotsanjay.vehicletypes.Truck;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.createInstance();
        Level level = new Level(1, 10);
        Vehicle car = new Car("ABXXCD");
        Vehicle bike = new Bike("GHJKKX");
        Vehicle truck = new Truck("NBJHIU");
        parkingLot.addLevel(level);

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(truck);

        parkingLot.getAvailability();
        parkingLot.unparkVehicle(bike);

        parkingLot.getAvailability();

    }
}
