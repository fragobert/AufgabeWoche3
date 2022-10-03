public class LKW extends Vehicle {
    private static int counter;
    final private int index;
    final private int maxWeight;

    public LKW(int model, int fuelConsumption, int fuelTankCapacity, String name, String color, String brand, int maxWeight) {
        super(model, fuelConsumption, fuelTankCapacity, name, color, brand);
        counter++;
        index = counter;
        this.maxWeight = maxWeight;
    }

    public void printDescription() {
        System.out.println("Ich bin ein " + super.getColor() + "er " + super.getName() + ", Modell " + super.getModel() + " von der Marke " + super.getBrand() + ".");
        System.out.println("Ich verbrauche " + super.getFuelConsumption() + " liter Benzin pro Kilometer und habe noch " + super.getFuelLevel() + " Liter im Tank!");
        System.out.println("Ich kann maximal " + maxWeight + " kg transportieren!");
    }

    public int getIndexLKW() {
        return index;
    }
}
