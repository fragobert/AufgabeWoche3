import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Autos sollen erstellt werden?");
        int carAmount = scanner.nextInt();
        CarRental cr1 = new CarRental(carAmount);
        System.out.println("Wie viele LKWs sollen erstellt werden?");
        int LKWAmount = scanner.nextInt();
        LKWRental lr1 = new LKWRental(LKWAmount);
        //endless while loop
        while (true) {
            System.out.println("1. Mit Autos interagieren");
            System.out.println("2. Mit LKWs interagieren");
            System.out.println("3. Programm beenden");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> cr1.menu();
                case 2 -> lr1.menu();
                case 3 -> System.exit(0);
                case default -> System.out.println("Falsche Eingabe!");
            }

        }
    }
}