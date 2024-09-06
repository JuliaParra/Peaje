package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MotorcycleTest {

    @Test
    public void testCalculateToll() {
        Motorcycle motorcycle = new Motorcycle("XYZ789");
        assertEquals(50, motorcycle.calculateToll());
    }

    @Test
    public void testLicensePlate() {
        Motorcycle motorcycle = new Motorcycle("XYZ789");
        assertEquals("XYZ789", motorcycle.getLicensePlate());
    }
}
