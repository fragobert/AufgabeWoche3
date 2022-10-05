public class Car extends Vehicle {
    private static int counter;
    final private int index;
    final private int topSpeed;


    public Car(int model, int fuelConsumption, int fuelTankCapacity, int topSpeed,  String name, String color, String brand) {
        super(model, fuelConsumption, fuelTankCapacity, name, color, brand);
        counter++;

        index = counter;
        this.topSpeed = topSpeed;
    }

    public void printInfo() {
        System.out.println("Ich bin ein " + super.getColor() + "er " + super.getName() + ", Modell " + super.getModel() + " von der Marke " + super.getBrand() + ".");
        System.out.println("Ich verbrauche " + super.getFuelConsumption() + " liter Benzin pro Kilometer und habe noch " + super.getFuelLevel() + " Liter im Tank!");
        System.out.println("Meine Höchstgeschwindigkeit ist "+getTopSpeed()+"km/h");
    }
    public int getIndexCar() {
        return index;
    }
    public int getTopSpeed(){
        return topSpeed;
    }
}