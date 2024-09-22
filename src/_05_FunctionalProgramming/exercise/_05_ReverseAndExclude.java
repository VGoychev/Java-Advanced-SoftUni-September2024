package _05_FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<Integer> reversed = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDevisible = number -> number % n == 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!isDevisible.test(numbers[i])){
                reversed.add(numbers[i]);
            }
        }
        for (int a : reversed){
            System.out.print(a + " ");
        }
    }
}
