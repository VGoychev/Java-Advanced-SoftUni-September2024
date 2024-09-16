package _03_SetsAndDictionaries.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")) {
                    parkingLot.add(reminder[1]);
                } else if (reminder[0].equals("OUT")) {
                    parkingLot.remove(reminder[1]);
                }
            }
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (Object car : parkingLot){
                System.out.println(car);
            }
        }
    }
}
