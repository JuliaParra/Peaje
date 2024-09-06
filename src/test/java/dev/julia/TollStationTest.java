package dev.julia;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TollStationTest {

    private TollStation tollStation;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("Toll Station 1", "City X");
    }

    @Test
    public void testGetName() {
        assertEquals("Toll Station 1", tollStation.getName());
    }

    @Test
    public void testSetName() {
        tollStation.setName("New Toll Station");
        assertEquals("New Toll Station", tollStation.getName());
    }

    @Test
    public void testGetCity() {
        assertEquals("City X", tollStation.getCity());
    }

    @Test
    public void testSetCity() {
        tollStation.setCity("New City");
        assertEquals("New City", tollStation.getCity());
    }

    @Test
    public void testGetTotalCollected() {
        assertEquals(0, tollStation.getTotalCollected());
    }

    @Test
    public void testGetVehiclesInitiallyEmpty() {
        List<Vehicle> vehicles = tollStation.getVehicles();
        assertNotNull(vehicles);
        assertEquals(0, vehicles.size());
    }

    @Test
    public void testSetVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("ABC123"));
        tollStation.setVehicles(vehicles);

        List<Vehicle> registeredVehicles = tollStation.getVehicles();
        assertEquals(1, registeredVehicles.size());
        assertEquals("ABC123", registeredVehicles.get(0).getLicensePlate());
    }

    @Test
    public void testRegisterVehicleAndTotalCollected() {
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
        Vehicle car = new Car("ABC123");
        tollStation.registerVehicle(car);

        tollStation.showReport();  
    }

    @Test
    public void testEmptyStation() {
        assertEquals(0, tollStation.getTotalCollected());
        assertEquals(0, tollStation.getVehicles().size());
    }

    @Test
    public void testMultipleVehicleRegistrations() {
        Vehicle car1 = new Car("ABC123");
        Vehicle car2 = new Car("DEF456");
        Vehicle motorcycle = new Motorcycle("XYZ789");

        tollStation.registerVehicle(car1);
        tollStation.registerVehicle(car2);
        tollStation.registerVehicle(motorcycle);

        assertEquals(100 + 100 + 50, tollStation.getTotalCollected());
        assertEquals(3, tollStation.getVehicles().size());
    }

    @Test
    public void testRegisterTruckWithZeroAxles() {
        Vehicle truck = new Truck("LMN456", 0);
        tollStation.registerVehicle(truck);

        assertEquals(0, truck.calculateToll());
        assertEquals(0, tollStation.getTotalCollected());
    }
}
