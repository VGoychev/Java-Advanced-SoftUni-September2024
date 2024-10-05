package _08_Generics.exercise._04_GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(number);
            boxes.add(box);
        }
        int[] swapElements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        swapData(boxes, swapElements[0], swapElements[1]);
        for (int i = 0; i < boxes.size(); i++) {
            System.out.println(boxes.get(i));
        }
    }
    private static <T> void swapData(List<T> list, int first, int second){
        T firstElement = list.get(first);
        T secondElement = list.get(second);

        list.set(first, secondElement);
        list.set(second, firstElement);
    }
}
