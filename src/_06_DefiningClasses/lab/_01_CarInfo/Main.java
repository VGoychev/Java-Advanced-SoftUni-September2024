package _06_DefiningClasses.lab._01_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Car car = new Car();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            car.setBrand(carInfo[0]);
            car.setModel(carInfo[1]);
            car.setHorsePower(Integer.parseInt(carInfo[2]));
            System.out.println(car.carInfo());
        }

    }
}
