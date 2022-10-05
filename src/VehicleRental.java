import java.util.ArrayList;

public class VehicleRental {
    private static final String[] colors = {"red", "blue", "green", "yellow", "black", "white", "brown", "orange", "purple"};
    private static final String[] colorsInConsole = {ConsoleColors.RED, ConsoleColors.BLUE, ConsoleColors.GREEN, ConsoleColors.YELLOW, ConsoleColors.BLACK, ConsoleColors.WHITE, ConsoleColors.BROWN, ConsoleColors.ORANGE, ConsoleColors.PURPLE};

    private Vehicle[] vehicles;
    private ArrayList<Vehicle> rentedVehicles = new ArrayList<>();

    public VehicleRental(int arraySize) {
        if (arraySize >= 0) {
            vehicles = new Vehicle[arraySize];

        }else{
            System.out.println(ConsoleColors.RED + "Error: Number must be a positive integer!" + ConsoleColors.RESET);
            System.exit(0);
        }
    }
}
