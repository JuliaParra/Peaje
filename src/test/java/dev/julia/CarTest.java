package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testCalculateToll() {
        Car car = new Car("ABC123");
        assertEquals(100, car.calculateToll());
    }

    @Test
    public void testLicensePlate() {
        Car car = new Car("ABC123");
        assertEquals("ABC123", car.getLicensePlate());
    }
}