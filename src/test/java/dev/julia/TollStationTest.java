package dev.julia;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TollStationTest {

    @Test
    public void testRegisterVehicleAndTotalCollected() {
        TollStation tollStation = new TollStation("Toll Station 1", "City X");

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("XYZ789");
        Vehicle truck = new Truck("LMN456", 3); 

        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorcycle);
        tollStation.registerVehicle(truck);

        assertEquals(100 + 50 + 150, tollStation.getTotalCollected()); 
    }

    @Test
    public void testVehiclesRegistered() {
        TollStation tollStation = new TollStation("Toll Station 1", "City X");

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("XYZ789");

        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorcycle);

        List<Vehicle> registeredVehicles = tollStation.getVehicles();
        assertEquals(2, registeredVehicles.size());
        assertEquals("ABC123", registeredVehicles.get(0).getLicensePlate());
        assertEquals("XYZ789", registeredVehicles.get(1).getLicensePlate());
    }

    @Test
    public void testShowReport() {
        TollStation tollStation = new TollStation("Toll Station 1", "City X");

        Vehicle car = new Car("ABC123");
        tollStation.registerVehicle(car);

        tollStation.showReport();  
    }
}
