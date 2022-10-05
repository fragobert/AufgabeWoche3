import java.util.ArrayList;

public class VehicleRental {
    private static final String[] colors = {"red", "blue", "green", "yellow", "black", "white", "brown", "orange", "purple"};
    private static final String[] colorsInConsole = {ConsoleColors.RED, ConsoleColors.BLUE, ConsoleColors.GREEN, ConsoleColors.YELLOW, ConsoleColors.BLACK, ConsoleColors.WHITE, ConsoleColors.BROWN, ConsoleColors.ORANGE, ConsoleColors.PURPLE};

    private Vehicle[] vehicles;
    private ArrayList<Vehicle> rentedVehicles = new ArrayList<>();

    public VehicleRental() {

    }
    protected String getRandom(String[] array) {
        return array[(int) (Math.random() * array.length)];
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public boolean isAvailable(Vehicle vehicle) {
        return !rentedVehicles.contains(vehicle);
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
