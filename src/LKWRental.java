import java.util.ArrayList;

public class LKWRental extends VehicleRental{
    private static final String[] brands = {"MAN", "Mercedes", "Iveco", "Scania", "Volvo", "Renault", "Volvo", "Dongfeng"};
    private static final String[] names = {};
    private final ArrayList<LKW> LKWs = new ArrayList<LKW>();


    public LKWRental(int arraySize) {
        super(arraySize);
    }
    public ArrayList<LKW> getLKWs(){
        return LKWs;
    }
}
