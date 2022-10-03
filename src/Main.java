import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Autos sollen erstellt werden?");
        int carAmount = scanner.nextInt();
        CarRental cr1 = new CarRental(carAmount);
        //endless while loop
        while (true) {
            //print menu
            System.out.print(ConsoleColors.CYAN);
            System.out.println("1. Alle existierenden Autos anzeigen");
            System.out.println("2. Alle bereits vermieteten Autos anzeigen");
            System.out.println("3. Auto ausleihen");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Auto suchen");
            System.out.println("6. Nachsehen ob Auto verfuegbar ist");
            System.out.println("7. Programm beenden");
            System.out.print(ConsoleColors.RESET);
            //get user input

            int input = scanner.nextInt();
            //switch case for user input
            switch (input) {
                case 1 -> cr1.getCarstoString();
                case 2 -> cr1.getRentedCarsToString();
                case 3 -> {
                    System.out.println("Bitte geben Sie den Index des Autos an welches sie ausleihen moechten:");
                    cr1.rentCar(scanner.nextInt());
                }
                case 4 -> {
                    if(!cr1.getRentedCars().isEmpty()) {
                        System.out.println("Bitte geben Sie den Index des Autos an welches sie zurueckgeben moechten:");
                        cr1.returnCar(scanner.nextInt());
                    }else{
                        System.out.println(ConsoleColors.RED+"Es wurden keine Autos ausgeliehen"+ConsoleColors.RESET);
                    }
                }
                case 5 -> {
                    System.out.println("Geben sie die Marke des Autos an:");
                    String brand = scanner.next();
                    System.out.println("Geben sie den Namen des Autos an:");
                    String name = scanner.next();
                    System.out.println("Geben sie die Farbe des Autos an:");
                    String color = scanner.next();
                    ArrayList<Car> foundCars = cr1.findCar(brand, name, color);
                    if (foundCars.size() == 0) {
                        System.out.println(ConsoleColors.RED + "Es wurden keine Autos gefunden!" + ConsoleColors.RESET);
                    } else {
                        System.out.println("Es wurden " + foundCars.size() + " gefunden!");
                        System.out.println(cr1.CarListToString(foundCars));
                    }

                }
                case 6 -> {
                    System.out.println("Geben Sie bitte den Index des Autos an:");
                    if (cr1.isAvailable(cr1.getCar(scanner.nextInt()))) {
                        System.out.println("Das Auto ist verfügbar!");
                    } else {
                        System.out.print(ConsoleColors.RED + "Auto ist nicht verfuegbar!" + ConsoleColors.RESET);
                    }

                }
                case 7 -> {
                    System.out.print("Programm wird beendet...");

                    System.exit(0);
                }
                default -> {
                    System.out.println(ConsoleColors.RED + "Ungueltige Eingabe!" + ConsoleColors.RESET);

                }
            }
        }
    }
}