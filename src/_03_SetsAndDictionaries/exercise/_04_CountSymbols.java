package _03_SetsAndDictionaries.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> counter = new TreeMap<>();
        char[] symbols = scanner.nextLine().toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (counter.containsKey(symbols[i])) {
                counter.put(symbols[i], counter.get(symbols[i]) + 1);
            } else {
                counter.put(symbols[i], 1);
            }
        }
        counter.entrySet().forEach(entry -> {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        });
    }
}
