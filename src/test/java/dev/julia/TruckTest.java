package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TruckTest {

    @Test
    public void testCalculateToll() {
        Truck truck = new Truck("LMN456", 4);
        assertEquals(200, truck.calculateToll()); // 4 axles, $50 per axle
    }

    @Test
    public void testAxles() {
        Truck truck = new Truck("LMN456", 3);
        assertEquals(3, truck.getAxles());
        truck.setAxles(5);
        assertEquals(5, truck.getAxles());
    }

    @Test
    public void testLicensePlate() {
        Truck truck = new Truck("LMN456", 2);
        assertEquals("LMN456", truck.getLicensePlate());
    }
}