package _ExamPreparation_05_.Task_01_;

import java.util.*;
import java.util.stream.Collectors;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuel = new ArrayDeque<>();

        ArrayDeque<Integer> consumption = new ArrayDeque<>();

        ArrayDeque<Integer> neededFuel = new ArrayDeque<>();

        List<String> altitudeReached = new ArrayList<>();

        ArrayDeque<String> altitudeNames = new ArrayDeque<>(List.of("Altitude 1", "Altitude 2", "Altitude 3", "Altitude 4"));

        Map<String, Integer> altitudesWithValues = new LinkedHashMap<>();

        int[] initialFuel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] consumptionIndex = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] fuelNeeded = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < initialFuel.length; i++) {
            fuel.push(initialFuel[i]);
        }
        for (int i = 0; i < consumptionIndex.length; i++) {
            consumption.offer(consumptionIndex[i]);
        }
        for (int i = 0; i < fuelNeeded.length; i++) {
            neededFuel.offer(fuelNeeded[i]);
        }

        altitudeNames.forEach(key -> {
            if (!neededFuel.isEmpty()) {
                int value = neededFuel.poll();
                altitudesWithValues.put(key, value);
            }
        });

        while (!fuel.isEmpty() && !consumption.isEmpty() && !altitudesWithValues.isEmpty()){

            String currentLevel = altitudeNames.getFirst();

            int currentFuel = fuel.pop();
            int additionalConsumption = consumption.poll();

            int result = currentFuel - additionalConsumption;

            if (result >= altitudesWithValues.get(currentLevel)){

                altitudeReached.add(currentLevel);

                altitudesWithValues.remove(currentLevel);
                altitudeNames.remove(currentLevel);

                System.out.println("John has reached: " + currentLevel);

            } else if (result < altitudesWithValues.get(currentLevel)){
                altitudeNames.remove();
                System.out.println("John did not reach: " + currentLevel);

                break;
            }

        }
        if (altitudesWithValues.isEmpty()){
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
            if (!altitudeReached.isEmpty()) {
                System.out.print("Reached altitudes: " + altitudeReached.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                System.out.println("John didn't reach any altitude.");

            }
        }
    }
}
