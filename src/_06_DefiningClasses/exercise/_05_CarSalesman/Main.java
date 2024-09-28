package _06_DefiningClasses.exercise._05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Car car;
        Engine engine;
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] engineInformation = scanner.nextLine().split(" ");
            String model = engineInformation[0];
            int power = Integer.parseInt(engineInformation[1]);
            String displacement = "n/a";
            String efficiently = "n/a";
            if (engineInformation.length == 3) {
                if (isNumeric(engineInformation[2])){
                    displacement = engineInformation[2];
                } else {
                    efficiently = engineInformation[2];
                }
            } else if ( engineInformation.length == 4){
                displacement = engineInformation[2];
                efficiently = engineInformation[3];
            }
            engine = new Engine(model, power, displacement, efficiently);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInformation = scanner.nextLine().split(" ");
            String carModel = carInformation[0];
            String carEngine = carInformation[1];
            String weight = "n/a";
            String color = "n/a";
            if (carInformation.length == 3){
                if (isNumeric(carInformation[2])){
                    weight = carInformation[2];
                } else {
                    color = carInformation[2];
                }
            } else if (carInformation.length == 4){
                weight = carInformation[2];
                color = carInformation[3];
            }
            car = new Car(carModel, carEngine, weight, color);
            carList.add(car);
        }
        for (Car car1 : carList){
            System.out.println(car1.getModel()+":");
            System.out.println(car1.getEngine()+":");
            for (Engine engine1 : engineList){
                if (engine1.getModel().equals(car1.getEngine())){
                    System.out.println("Power: "+ engine1.getPower());
                    System.out.println("Displacement: "+ engine1.getDisplacement());
                    System.out.println("Efficiency: "+ engine1.getEfficiency());
                }
            }
            System.out.println("Weight: "+ car1.getWeight());
            System.out.println("Color: " + car1.getColor());
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
