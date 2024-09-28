package _06_DefiningClasses.exercise._03_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Car car;
        Engine engine;
        Cargo cargo;
        Tires tires;
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");

                String model = input[0];
                int engineSpeed = Integer.parseInt(input[1]);
                int enginePower = Integer.parseInt(input[2]);
                int cargoWeight = Integer.parseInt(input[3]);
                String cargoType = input[4];
                double tire1Pressure = Double.parseDouble(input[5]);
                int tire1Age = Integer.parseInt(input[6]);
                double tire2Pressure = Double.parseDouble(input[7]);
                int tire2Age = Integer.parseInt(input[8]);
                double tire3Pressure = Double.parseDouble(input[9]);
                int tire3Age = Integer.parseInt(input[10]);
                double tire4Pressure = Double.parseDouble(input[11]);
                int tire4Age = Integer.parseInt(input[12]);

                engine = new Engine(engineSpeed, enginePower);
                cargo = new Cargo(cargoWeight, cargoType);
                tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
                car = new Car(model, engine, cargo, tires);

                carsList.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
            for (Car car1 : carsList){
                if (car1.getCargo().getCargoType().equals(command)){
                    if (car1.getTires().getTyre1Pressure() < 1 || car1.getTires().getTyre2Pressure() < 1 || car1.getTires().getTyre3Pressure() < 1 || car1.getTires().getTyre4Pressure() < 1) {
                        System.out.println(car1.getModel());
                    }
                }
            }
        } else if(command.equals("flamable")){
            for (Car car1 : carsList){
                if( car1.getCargo().getCargoType().equals(command) && car1.getEngine().getEnginePower() > 250){
                    System.out.println(car1.getModel());
                }
            }
        }
    }
}
