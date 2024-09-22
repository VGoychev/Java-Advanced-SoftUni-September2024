package _05_FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Predicate<String> isUpperCase = c -> Character.isUpperCase(c.charAt(0));
        List<String> words = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (isUpperCase.test(input[i])) {
                words.add(input[i]);
            }
        }
        System.out.println(words.size());
        for (String word : words){
            System.out.println(word);
        }
    }
}
