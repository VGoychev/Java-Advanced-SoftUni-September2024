package _06_DefiningClasses.lab._02_CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.contains(" ")) {
                String[] tokens = input.split(" ");

                String brand = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(brand, model, horsePower);
                System.out.println(car.carInfo());
            } else {
                Car car = new Car(input);
                System.out.println(car.carInfo());
            }
        }
    }
}
