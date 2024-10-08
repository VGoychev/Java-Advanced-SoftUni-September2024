package _03_SetsAndDictionaries.lab;

import java.util.*;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> counter = new LinkedHashMap<>();
        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for (int i = 0; i < numbers.length; i++) {
            if (counter.containsKey(numbers[i])) {
                counter.put(numbers[i], counter.get(numbers[i]) + 1);
            } else {
                counter.put(numbers[i], 1);
            }
        }
        counter.entrySet().forEach(entry -> {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        });
    }
}
