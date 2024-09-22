package _05_FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {
            boolean isDivisible = true;
            int currentNumber = i;
            for (int j = 0; j < numbers.size(); j++) {
                Predicate<Integer> check = a -> currentNumber % a != 0;
                if (check.test(numbers.get(j))){
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible){
                System.out.print(currentNumber + " ");
            }
        }
    }
}
