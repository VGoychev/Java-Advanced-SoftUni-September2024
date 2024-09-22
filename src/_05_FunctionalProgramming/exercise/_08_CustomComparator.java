package _05_FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Comparator<Integer> comparator = (first, seconds) -> {
            if (first % 2 == 0 && seconds % 2 != 0) {
                return -1;
            }
            if (first % 2 != 0 && seconds % 2 == 0) {
                return 1;
            }
            return first.compareTo(seconds);
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
