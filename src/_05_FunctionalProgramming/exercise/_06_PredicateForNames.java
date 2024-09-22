package _05_FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Predicate;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");
        Predicate<String> isTrue = name -> name.length() <= n;

        for (String name : names){
            if (isTrue.test(name)){
                System.out.println(name);
            }
        }
    }
}
