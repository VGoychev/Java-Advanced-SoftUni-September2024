package _05_FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> minNumber = list -> Arrays.stream(list).mapToInt(e -> e).min().getAsInt();

        int smallestNumber = minNumber.apply(input);
        System.out.println(smallestNumber);
    }
}
