package _08_Generics.exercise._05_GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxes.add(box);
        }
        String value = scanner.nextLine();
        Box<String> valueBox = new Box<>(value);

        int results = counter(boxes, valueBox);
        System.out.println(results);
    }
    private static <T extends Comparable<T>> int counter(List<T> boxList, T valueToCompare){
        int count = 0;
        for (T t : boxList){
            int result = t.compareTo(valueToCompare);
            if (result > 0){
                count++;
            }
        }
        return count;
    }
}
