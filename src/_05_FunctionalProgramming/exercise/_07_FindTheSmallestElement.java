package _05_FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestNumbers = list -> Collections.min(list);

        int smallestNumber = findSmallestNumbers.apply(numbers);

        System.out.println(numbers.lastIndexOf(smallestNumber));
    }
}
