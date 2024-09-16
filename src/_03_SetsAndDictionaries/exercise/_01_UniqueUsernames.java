package _03_SetsAndDictionaries.exercise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueWord = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (!uniqueWord.contains(input)){
                uniqueWord.add(input);
            }
        }
        for (Object o : uniqueWord){
            System.out.println(o);
        }
    }
}
