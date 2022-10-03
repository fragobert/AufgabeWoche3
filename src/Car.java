public class Car extends Vehicle {
    private static int counter;
    final private int index;


    public Car(int model, int fuelConsumption, int fuelLevel, String name, String color, String brand) {
        super(model, fuelConsumption, fuelLevel, name, color, brand);
        counter++;
        index = counter;
    }

    public void printDescription() {
        System.out.println("Ich bin ein " + super.getColor() + "er " + super.getName() + ", Modell " + super.getModel() + " von der Marke " + super.getBrand() + ".");
        System.out.println("Ich verbrauche " + super.getFuelConsumption() + " liter Benzin pro Kilometer und habe noch " + super.getFuelLevel() + " Liter im Tank!");
    }
    public int getIndexCar() {
        return index;
    }
}