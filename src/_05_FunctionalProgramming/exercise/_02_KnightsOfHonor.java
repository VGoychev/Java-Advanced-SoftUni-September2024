package _05_FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Consumer<String> printName = name -> System.out.println("Sir " + name);

        for (String name : input){
            printName.accept(name);
        }
    }
}
