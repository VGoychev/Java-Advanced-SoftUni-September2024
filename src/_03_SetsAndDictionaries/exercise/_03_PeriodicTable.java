package _03_SetsAndDictionaries.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
