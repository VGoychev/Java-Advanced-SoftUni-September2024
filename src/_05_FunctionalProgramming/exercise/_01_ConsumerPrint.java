package _05_FunctionalProgramming.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Consumer<String> printName = name -> System.out.println(name);

        for (String name : input){
            printName.accept(name);
        }
    }
}
