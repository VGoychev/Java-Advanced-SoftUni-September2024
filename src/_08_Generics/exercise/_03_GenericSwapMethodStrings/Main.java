package _08_Generics.exercise._03_GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxes.add(box);

        }
        String[] command = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(command[0]);
        int secondIndex = Integer.parseInt(command[1]);
        swapData(boxes, firstIndex, secondIndex);
        for (int i = 0; i < boxes.size(); i++) {
            System.out.println(boxes.get(i));
        }
    }

    private static <T> void swapData(List<T> list, int firstIndex, int secondIndex){
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);
        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);

    }
}
