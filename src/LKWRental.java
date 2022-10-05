import java.util.ArrayList;

public class LKWRental extends VehicleRental{
    private static final String[] brands = {"MAN", "Mercedes", "Iveco", "Scania", "Volvo", "Renault", "Volvo", "Dongfeng"};
    private static final String[] names = {"Actros", "Atego", "Stralis", "T", "FH", "FM", "FL", "FE"};
    private final ArrayList<LKW> LKWs = new ArrayList<>();

    public LKWRental(int arraySize) {
        super();
        if (arraySize < 0) {
            System.out.println(ConsoleColors.RED + "Fehler: Die Anzahl der LKWs darf nicht kleiner als 0 sein!" + ConsoleColors.RESET);
            System.exit(0);
        }
        for (int i = 0; i < arraySize; i++) {
            LKWs.add(new LKW((int)(Math.random()*1000),(int)(Math.random()*10),(int)(Math.random()*100),(int)(Math.random()*10000),getRandom(names),getRandom(super.getColors()),getRandom(brands)));
        }
    }
    public ArrayList<LKW> getLKWs(){
        return LKWs;
    }
    public ArrayList<LKW> findLKW(String brands, String names, String colors) {
        ArrayList<LKW> foundLKWs = new ArrayList<>();
        for (LKW LKW : LKWs) {
            if (LKW.getBrand().equals(brands) && LKW.getName().equals(names) && LKW.getColor().equals(colors)) {
                foundLKWs.add(LKW);
            }
        }
        return foundLKWs;
    }
}
