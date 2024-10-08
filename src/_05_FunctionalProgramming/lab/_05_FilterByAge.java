package _05_FunctionalProgramming.lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> list = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            list.put(input[0], Integer.parseInt(input[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        printOutput(list, condition, age, format);
    }

    private static void printOutput(Map<String, Integer> info, String condition, int age, String format) {
        info.entrySet().forEach(entry -> {
            if (condition.equals("younger")) {
                if (entry.getValue() <= age) {
                    if (format.equals("name")) {
                        System.out.printf("%s%n", entry.getKey());
                    } else if (format.equals("age")) {
                        System.out.printf("%d%n", entry.getValue());
                    } else if (format.equals("name age")) {
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    }
                }
            } else if (condition.equals("older")) {
                if (entry.getValue() >= age) {
                    if (format.equals("name")) {
                        System.out.printf("%s%n", entry.getKey());
                    } else if (format.equals("age")) {
                        System.out.printf("%d%n", entry.getValue());
                    } else if (format.equals("name age")) {
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    }
                }
            }
        });
    }
}
