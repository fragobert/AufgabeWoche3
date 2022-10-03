public class Vehicle {
    final private int model, fuelConsumption, fuelTankCapacity;
    private int fuelLevel;
    final private String name, color, brand;

    public Vehicle(int model, int fuelConsumption, int fuelTankCapacity, String name, String color, String brand) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.fuelTankCapacity = fuelTankCapacity;
        fuelLevel = fuelTankCapacity;
    }

    public int getMaxKilometers() {
        return fuelLevel / fuelConsumption;
    }

    public boolean isReachable(int km) {
        return fuelLevel / fuelConsumption >= km;
    }

    public void drive(int km) {
        if (isReachable(km)) fuelLevel -= fuelConsumption * km;
    }

    public int getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public int getFuelLevel() {
        return fuelLevel;
    }
    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }
}
