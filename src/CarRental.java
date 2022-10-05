import java.util.ArrayList;
import java.util.Scanner;

public class CarRental extends VehicleRental {
    private static final String[] brands = {"BMW", "Mercedes", "Audi", "VW", "Opel", "Ford", "Fiat", "Renault", "Peugeot", "Citroen"};
    private static final String[] names = {"M3", "A45", "RS6", "Golf_GTI", "Astra", "Focus", "500", "Clio", "308", "C4"};
    private static final String[] colors = {"rot", "blau", "schwarz", "weiß", "grün", "gelb", "orange", "violett", "pink", "braun"};
    private final ArrayList<Car> cars = new ArrayList<>();
    private final ArrayList<Car> rentedCars = new ArrayList<>();

    public CarRental(int arraySize) {
        if (arraySize < 0) {
            System.out.println(ConsoleColors.RED + "Fehler: Die Anzahl der Autos darf nicht kleiner als 0 sein!" + ConsoleColors.RESET);
            System.exit(0);
        }
        for (int i = 0; i < arraySize; i++) {
            cars.add(new Car((int) (Math.random() * 1000), (int) (Math.random() * 10), (int) (Math.random() * 100), (int) (Math.random() * 1000), getRandom(names), getRandom(colors), getRandom(brands)));
        }
    }


    public ArrayList<Car> findCar(String brands, String names, String colors) {
        ArrayList<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brands) && car.getName().equals(names) && car.getColor().equals(colors)) {
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


        System.out.println(ConsoleColors.BOXING + " Index" + "\t" + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Color") + " " + stringFormatter("Model") + " ");
        for (Car car : cars) {
            if (car.getIndexCar() > 99) {
                tabs = "\t";
            } else tabs = "\t\t";
            carList.append(ConsoleColors.WHITE_BRIGHT + " ").append(car.getIndexCar()).append(tabs).append(stringFormatter(car.getBrand())).append(" ").append(stringFormatter(car.getName())).append(" ").append(stringFormatter(car.getColor())).append(" ").append(stringFormatter(Integer.toString(car.getModel()))).append("\n");
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
            System.out.println(ConsoleColors.CYAN);
            System.out.println("1. Alle Autos anzeigen");
            System.out.println("2. ALle bereits vermieteten Autos anzeigen");
            System.out.println("3. Auto mieten");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Auto suchen");
            System.out.println("6. Nachsehen ob Auto verfuegbar ist");
            System.out.println("7. Zurück zum Hauptmenü");
            System.out.println(ConsoleColors.RESET);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> this.getCarsToString();
                case 2 -> this.getRentedCarsToString();
                case 3 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie mieten möchten:");
                    int index = scanner.nextInt();
                    if (this.rentCar(this.cars.get(index - 1))) {
                        System.out.println(ConsoleColors.GREEN + "LKW erfolgreich vermietet!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "LKW nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie zurückgeben möchten:");
                    int index = scanner.nextInt();
                    if (this.rentedCars.remove(this.cars.get(index))) {
                        System.out.println(ConsoleColors.GREEN + "LKW erfolgreich zurückgegeben!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "LKW nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 5 -> {
                    System.out.println("Bitte geben Sie die Marke des LKWs ein, den Sie suchen möchten:");
                    String brand = scanner.next();
                    System.out.println("Bitte geben Sie den Namen des LKWs ein, den Sie suchen möchten:");
                    String name = scanner.next();
                    System.out.println("Bitte geben Sie die Farbe des LKWs ein, den Sie suchen möchten:");
                    String color = scanner.next();
                    System.out.println(this.CarListToString(this.findCar(brand, name, color)));
                }
                case 6 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie nachsehen möchten:");
                    int index = scanner.nextInt();
                    if (this.isAvailable(this.cars.get(index))) {
                        System.out.println(ConsoleColors.GREEN + "LKW verfügbar!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "LKW nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 7 -> exit = true;
                case default -> System.out.println(ConsoleColors.RED + "Ungültige Eingabe!" + ConsoleColors.RESET);
            }
        }
    }
}