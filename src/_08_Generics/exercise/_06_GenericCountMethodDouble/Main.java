package _08_Generics.exercise._06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(input);
            list.add(box);
        }
        double value = Double.parseDouble(scanner.nextLine());
        Box<Double> box = new Box<>(value);

        int result = counter(list, box);
        System.out.println(result);
    }
    private static <T extends Comparable<T>> int counter(List<T> boxList, T valueToCompare){
        int counter = 0;
        for (T t : boxList){
           int result =  t.compareTo(valueToCompare);
            if (result > 0){
                counter++;
            }
        }
        return  counter;
    }
}
