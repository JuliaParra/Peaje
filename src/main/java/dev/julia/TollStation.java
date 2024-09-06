package dev.julia;

import java.util.ArrayList;
import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private int totalCollected;
    private List<Vehicle> vehicles;

  
    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalCollected = 0;
        this.vehicles = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCity() {
        return city;
    }

  
    public void setCity(String city) {
        this.city = city;
    }

   
    public int getTotalCollected() {
        return totalCollected;
    }

 
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


   
    public void registerVehicle(Vehicle vehicle) {
        int toll = vehicle.calculateToll();
        totalCollected += toll;
        vehicles.add(vehicle);
    }

    public void showReport() {
        System.out.println("Toll Station: " + name + " in " + city);
        System.out.println("Vehicles that passed:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(" - License Plate: " + vehicle.getLicensePlate() + ", Toll: $" + vehicle.calculateToll());
        }
        System.out.println("Total Collected: $" + totalCollected);
    }
}
