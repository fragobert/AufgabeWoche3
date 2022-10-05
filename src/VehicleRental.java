import java.util.ArrayList;

public class VehicleRental {
    private static final String[] colors = {ConsoleColors.RED + "Rot" + ConsoleColors.RESET, ConsoleColors.GREEN + "Grün" + ConsoleColors.RESET, ConsoleColors.BLUE + "Blau" + ConsoleColors.RESET, ConsoleColors.YELLOW + "Gelb" + ConsoleColors.RESET, ConsoleColors.CYAN + "Cyan" + ConsoleColors.RESET, ConsoleColors.PURPLE + "Lila" + ConsoleColors.RESET, ConsoleColors.WHITE + "Weiß" + ConsoleColors.RESET, ConsoleColors.BLACK + "Schwarz" + ConsoleColors.RESET};

    private Vehicle[] vehicles;
    private final ArrayList<Vehicle> rentedVehicles = new ArrayList<>();

    public VehicleRental() {

    }
    public String getRandom(String[] array) {
        return array[(int) (Math.random() * array.length)];
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
    public ArrayList<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public boolean isAvailable(Vehicle vehicle) {

        return !rentedVehicles.contains(vehicle);


    }
    public ArrayList<Vehicle> findVehicle(String brand, String name) {
        ArrayList<Vehicle> foundVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equals(brand) && vehicle.getName().equals(name)) {
                foundVehicles.add(vehicle);
            }
        }
        return foundVehicles;
    }
    public void rentVehicle(int index) {
        if (index <= vehicles.length && index > 0) {
            if (isAvailable(vehicles[index - 1])) {
                rentedVehicles.add(vehicles[index - 1]);
                System.out.println("Das Fahrzeug wurde erfolgreich ausgeliehen!");
            } else System.out.println(ConsoleColors.RED + "Fahrzeug ist nicht verfuegbar!" + ConsoleColors.RESET);
        } else System.out.println(ConsoleColors.RED + "Fahrzeug existiert nicht!" + ConsoleColors.RESET);
    }

    public String[] getColors() {
        return colors;
    }
}
