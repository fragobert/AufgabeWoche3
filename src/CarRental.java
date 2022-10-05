import java.util.ArrayList;
import java.util.Scanner;

public class CarRental extends VehicleRental {
    private static final String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static final String[] names = {"M3", "A45", "RS6", "Golf_GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private final ArrayList<Car> cars = new ArrayList<>();
    private final ArrayList<Car> rentedCars = new ArrayList<>();

    public CarRental(int arraySize) {
        if (arraySize < 0) {
            System.out.println(ConsoleColors.RED + "Fehler: Die Anzahl der Autos darf nicht kleiner als 0 sein!" + ConsoleColors.RESET);
            System.exit(0);
        }
        for (int i = 0; i < arraySize; i++) {
            cars.add(new Car((int) (Math.random() * 1000), (int) (Math.random() * 10)+1, (int) (Math.random() * 100), (int) (Math.random() * 1000), getRandom(names), getRandom(super.getColors()), getRandom(brands)));
        }
    }


    public ArrayList<Car> findCar(String brand, String name) {
        ArrayList<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brand) && car.getName().equals(name)) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    public ArrayList<Car> getRentedCars() {
        return rentedCars;
    }

    public boolean isAvailable(Car car) {
        return !rentedCars.contains(car);
    }

    public boolean rentCar(Car car) {
        if (isAvailable(car)) {
            rentedCars.add(car);
            return true;
        } else {
            return false;
        }
    }

    public void returnCar(int index) {
        if (index <= 0 || index > cars.size()) {
            System.out.println(ConsoleColors.RED + "Auto existiert nicht!" + ConsoleColors.RESET);
        } else {
            if (rentedCars.contains(cars.get(index - 1))) {
                rentedCars.remove(cars.get(index - 1));
                System.out.println("Das Auto wurde erfolgreich zurueckgegeben!");
            } else {
                System.out.println(ConsoleColors.RED + "Auto ist nicht ausgeliehen!" + ConsoleColors.RESET);
            }
        }
    }

    public Car getCar(int index) {
        if (index <= 0 || index > cars.size()) {
            System.out.println(ConsoleColors.RED + "Auto existiert nicht!" + ConsoleColors.RESET);
            return null;
        } else {
            return cars.get(index - 1);
        }
    }

    private static String stringFormatter(String string) {
        return String.format("%1$" + 10 + "s", string);
    }

    public String CarListToString(ArrayList<Car> cars) {
        StringBuilder carList = new StringBuilder();
        String tabs;


        System.out.println(ConsoleColors.BOXING + " Index" + "\t" + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Model") + " " + stringFormatter("Topspeed") + " "+ stringFormatter("Color") + " ");
        for (Car car : cars) {
            if (car.getIndexCar() > 99) {
                tabs = "\t";
            } else tabs = "\t\t";
            carList.append(ConsoleColors.WHITE_BRIGHT + " ").append(car.getIndexCar()).append(tabs).append(stringFormatter(car.getBrand())).append(" ").append(stringFormatter(car.getName())).append(" ").append(stringFormatter(Integer.toString(car.getModel()))).append(stringFormatter(Integer.toString(car.getTopSpeed()))).append("\t\t ").append(stringFormatter(car.getColor())).append("\n");

        }

        return carList.toString();
    }

    public void getCarsToString() {
        if (cars.size() == 0) {
            System.out.println(ConsoleColors.RED + "Keine Autos vorhanden!" + ConsoleColors.RESET);
        } else {
            System.out.println("Alle existierenden Autos:");
            System.out.println(CarListToString(cars));
        }

    }

    public void getRentedCarsToString() {
        if (rentedCars.size() == 0) {
            System.out.println(ConsoleColors.RED + "Keine Autos ausgeliehen!" + ConsoleColors.RESET);
        } else {
            System.out.println("Alle zurzeit vermieteten Autos:");
            System.out.println(CarListToString(rentedCars));
        }
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Alle Autos anzeigen");
            System.out.println("2. ALle bereits vermieteten Autos anzeigen");
            System.out.println("3. Auto mieten");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Auto suchen");
            System.out.println("6. Nachsehen ob Auto verfuegbar ist");
            System.out.println("7. Informationen zu einem Auto anzeigen");
            System.out.println("8. Zurück zum Hauptmenü");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> this.getCarsToString();
                case 2 -> this.getRentedCarsToString();
                case 3 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie mieten möchten:");
                    int index = scanner.nextInt();
                    if (this.rentCar(this.cars.get(index - 1))) {
                        System.out.println(ConsoleColors.GREEN + "Auto erfolgreich vermietet!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "Auto nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie zurückgeben möchten:");
                    int index = scanner.nextInt();
                    if (this.rentedCars.remove(this.cars.get(index))) {
                        System.out.println(ConsoleColors.GREEN + "Auto erfolgreich zurückgegeben!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "Auto nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 5 -> {
                    System.out.println("Bitte geben Sie die Marke des Autos ein, den Sie suchen möchten:");
                    String brand = scanner.next();
                    System.out.println("Bitte geben Sie den Namen des Autos ein, den Sie suchen möchten:");
                    String name = scanner.next();
                    ArrayList<Car> foundCars = this.findCar(brand, name);
                    if(foundCars.isEmpty()) {
                        System.out.println(ConsoleColors.RED + "Kein Auto gefunden!" + ConsoleColors.RESET);
                    } else {
                        System.out.println("Folgende Autos wurden gefunden:");
                        System.out.println(CarListToString(foundCars));
                    }
                }
                case 6 -> {
                    System.out.println("Bitte geben Sie die Index des Autos ein, den Sie nachsehen möchten:");
                    int index = scanner.nextInt();
                    if (this.isAvailable(this.cars.get(index))) {
                        System.out.println(ConsoleColors.GREEN + "Auto verfügbar!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "Auto nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 7 -> {
                    System.out.println("Bitte geben Sie die Index des Autos ein, zu dem Sie Informationen anzeigen möchten:");
                    int index = scanner.nextInt();
                    this.cars.get(index).printInfo();
                }
                case 8 -> exit = true;
                case default -> System.out.println(ConsoleColors.RED + "Ungültige Eingabe!" + ConsoleColors.RESET);
            }
        }
    }
}