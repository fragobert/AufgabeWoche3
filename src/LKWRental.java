import java.util.ArrayList;
import java.util.Scanner;

public class LKWRental extends VehicleRental {
    private static final String[] brands = {"MAN", "Mercedes", "Iveco", "Scania", "Volvo", "Renault", "Volvo", "Dongfeng"};
    private static final String[] names = {"Actros", "Atego", "Stralis", "T", "FH", "FM", "FL", "FE"};
    private final ArrayList<LKW> LKWs = new ArrayList<>();
    private final ArrayList<LKW> rentedLKWs = new ArrayList<>();

    public LKWRental(int arraySize) {
        super();
        if (arraySize < 0) {
            System.out.println(ConsoleColors.RED + "Fehler: Die Anzahl der LKWs darf nicht kleiner als 0 sein!" + ConsoleColors.RESET);
            System.exit(0);
        }
        for (int i = 0; i < arraySize; i++) {
            LKWs.add(new LKW((int) (Math.random() * 1000), (int) (Math.random() * 10)+1, (int) (Math.random() * 100), (int) (Math.random() * 10000), getRandom(names), getRandom(super.getColors()), getRandom(brands)));
        }
    }

    public ArrayList<LKW> findLKW(String brand, String name) {
        ArrayList<LKW> foundLKWs = new ArrayList<>();
        for (LKW LKW : LKWs) {
            if (LKW.getBrand().equals(brand) && LKW.getName().equals(name)) {
                foundLKWs.add(LKW);
            }
        }
        return foundLKWs;
    }

    public boolean isAvailable(LKW lkw) {
        return !rentedLKWs.contains(lkw);
    }

    public boolean rentLKW(LKW lkw) {
        if (isAvailable(lkw)) {
            rentedLKWs.add(lkw);
            return true;
        } else {
            return false;
        }
    }
    public boolean returnLKW(LKW lkw) {
        if (rentedLKWs.contains(lkw)) {
            rentedLKWs.remove(lkw);
            return true;
        } else {
            return false;
        }
    }

    private static String stringFormatter(String string) {
        return String.format("%1$" + 10 + "s", string);
    }

    private String LKWListToString(ArrayList<LKW> lkws) {
        StringBuilder LKWList = new StringBuilder();
        String tabs;


        System.out.println(ConsoleColors.BOXING + " Index" + "\t" + stringFormatter("Brand") + " " + stringFormatter("Name") + " " + stringFormatter("Model") + " " + stringFormatter("Capacity") + " "+ stringFormatter("Color") + " ");
        for (LKW lkw : lkws) {
            if (lkw.getIndexLKW() > 99) {
                tabs = "\t";
            } else tabs = "\t\t";
            LKWList.append(ConsoleColors.WHITE_BRIGHT + " ").append(lkw.getIndexLKW()).append(tabs).append(stringFormatter(lkw.getBrand())).append(" ").append(stringFormatter(lkw.getName())).append(" ").append(stringFormatter(Integer.toString(lkw.getModel()))).append(stringFormatter(Integer.toString(lkw.getMaxWeight()))).append("\t\t ").append(stringFormatter(lkw.getColor())).append("\n");
        }

        return LKWList.toString();
    }

    public void getLKWsToString() {
        if (LKWs.size() == 0) {
            System.out.println(ConsoleColors.RED + "Keine Autos vorhanden!" + ConsoleColors.RESET);
        } else {
            System.out.println("Alle existierenden Autos:");
            System.out.println(LKWListToString(LKWs));
        }

    }

    public void getRentedLKWsToString() {
        if (rentedLKWs.size() == 0) {
            System.out.println(ConsoleColors.RED + "Keine Autos ausgeliehen!" + ConsoleColors.RESET);
        } else {
            System.out.println("Alle zurzeit vermieteten Autos:");
            System.out.println(LKWListToString(rentedLKWs));
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Alle LKWs anzeigen");
            System.out.println("2. ALle bereits vermieteten LKWs anzeigen");
            System.out.println("3. LKW mieten");
            System.out.println("4. LKW zurückgeben");
            System.out.println("5. LKW suchen");
            System.out.println("6. Nachsehen ob LKW verfuegbar ist");
            System.out.println("7. Informationen zum LKW anzeigen");
            System.out.println("8. Zurück zum Hauptmenü");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> this.getLKWsToString();
                case 2 -> this.getRentedLKWsToString();
                case 3 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie mieten möchten:");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= LKWs.size()) {
                        System.out.println(ConsoleColors.RED + "Fehler: Der Index ist ungültig!" + ConsoleColors.RESET);
                    } else {
                        if (rentLKW(LKWs.get(index))) {
                            System.out.println(ConsoleColors.GREEN + "Der LKW wurde erfolgreich vermietet!" + ConsoleColors.RESET);
                        } else {
                            System.out.println(ConsoleColors.RED + "Der LKW ist bereits vermietet!" + ConsoleColors.RESET);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie zurückgeben möchten:");
                    int index = scanner.nextInt();
                    if(index < 0 || index >= LKWs.size()) {
                        System.out.println(ConsoleColors.RED + "Fehler: Der Index ist ungültig!" + ConsoleColors.RESET);
                    } else {
                        if (returnLKW(LKWs.get(index))) {
                            System.out.println(ConsoleColors.GREEN + "Der LKW wurde erfolgreich zurückgegeben!" + ConsoleColors.RESET);
                        } else {
                            System.out.println(ConsoleColors.RED + "Der LKW ist nicht vermietet!" + ConsoleColors.RESET);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Bitte geben Sie die Marke des LKWs ein, den Sie suchen möchten:");
                    String brand = scanner.next();
                    System.out.println("Bitte geben Sie den Namen des LKWs ein, den Sie suchen möchten:");
                    String name = scanner.next();
                    ArrayList<LKW> foundLKWs = findLKW(brand, name);
                    if(foundLKWs.isEmpty()) {
                        System.out.println(ConsoleColors.RED + "Es wurden keine LKWs gefunden!" + ConsoleColors.RESET);
                    } else {
                        System.out.println("Die folgenden LKWs wurden gefunden:");
                        System.out.println(LKWListToString(foundLKWs));
                    }
                }
                case 6 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie nachsehen möchten:");
                    int index = scanner.nextInt();
                    if (this.isAvailable(this.LKWs.get(index))) {
                        System.out.println(ConsoleColors.GREEN + "LKW verfügbar!" + ConsoleColors.RESET);
                    } else {
                        System.out.println(ConsoleColors.RED + "LKW nicht verfügbar!" + ConsoleColors.RESET);
                    }
                }
                case 7 -> {
                    System.out.println("Bitte geben Sie die Index des LKWs ein, den Sie nachsehen möchten:");
                    int index = scanner.nextInt();
                    if(index < 0 || index >= LKWs.size()) {
                        System.out.println(ConsoleColors.RED + "Fehler: Der Index ist ungültig!" + ConsoleColors.RESET);
                    } else {
                        this.LKWs.get(index).printInfo();
                    }

                }
                case 8 -> exit = true;
                case default -> System.out.println(ConsoleColors.RED + "Ungültige Eingabe!" + ConsoleColors.RESET);
            }
        }
    }
}
