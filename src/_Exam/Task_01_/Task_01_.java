package _Exam.Task_01_;

import java.util.*;
import java.util.stream.Collectors;

public class Task_01_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> strength = new ArrayDeque<>();
        ArrayDeque<Integer> accuracy = new ArrayDeque<>();
        int [] strengthValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] accuracyValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int totalGoals = 0;
        for (int i = 0; i < strengthValues.length; i++) {
            strength.push(strengthValues[i]);
        }
        for (int i = 0; i < accuracyValues.length; i++) {
            accuracy.offer(accuracyValues[i]);
        }

        while (!strength.isEmpty() && !accuracy.isEmpty()){
            int currentStrength = strength.peek();
            int currentAccuracy = accuracy.peek();

            int sum = currentStrength + currentAccuracy;

            if (sum == 100){
                totalGoals++;
                strength.pop();
                accuracy.poll();
            } else if (sum < 100){
                if (currentStrength > currentAccuracy){
                    accuracy.poll();
                } else if (currentStrength < currentAccuracy){
                    strength.pop();
                } else {
                   strength.pop();
                   strength.push(sum);
                   accuracy.poll();
                }
            } else {
               currentStrength = currentStrength - 10;
               strength.pop();
               strength.push(currentStrength);
               accuracy.poll();
               accuracy.offer(currentAccuracy);
            }

        }
        if (totalGoals == 3){
            System.out.println("Paul scored a hat-trick!");
        } else if (totalGoals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (totalGoals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else if (totalGoals > 0) {
            System.out.println("Paul failed to make a hat-trick.");
        }
        if (totalGoals > 0){
            System.out.println("Goals scored: " + totalGoals);
        }
        if (!strength.isEmpty()){
            List<Integer> reversedList = new ArrayList<>(strength);
            Collections.reverse(reversedList);
            String result = reversedList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Strength values left: " + result);
        } else if (!accuracy.isEmpty()) {
            System.out.println("Accuracy values left: " + accuracy.stream().
                    map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
