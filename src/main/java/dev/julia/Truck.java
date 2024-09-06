package dev.julia;

public class Truck extends Vehicle {
    private int axles;


    public Truck(String licensePlate, int axles) {
        super(licensePlate);
        this.axles = axles;
    }

    public int getAxles() {
        return axles;
    }



    public void setAxles(int axles) {
        this.axles = axles;
    }

    @Override
    public int calculateToll() {
        return 50 * axles; 
    }
}