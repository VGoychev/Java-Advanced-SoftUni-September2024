package _ExamPreparation_03_.Task_01_;

import java.util.*;
import java.util.stream.Collectors;

public class WildSurvival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bees = new ArrayDeque<>();
        ArrayDeque<Integer> eaters = new ArrayDeque<>();

        int[] beeCount = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] eaterCount = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < beeCount.length; i++) {
            bees.offer(beeCount[i]);
        }
        for (int i = 0; i < eaterCount.length; i++) {
            eaters.push(eaterCount[i]);
        }

        while (!bees.isEmpty() && !eaters.isEmpty()) {
                int currentBeeGroup = bees.poll();
                int currentEaterGroup = eaters.pop();

          if (currentBeeGroup >= 7) {
                currentBeeGroup -= 7; // Reduce the bee group by 7
                currentEaterGroup--; // Bee-eater dies if fighting a full group of bees
            } else {
                // If the bee group is less than 7, the bee-eater survives
                currentBeeGroup = 0; // All remaining bees are defeated
            }


            if (currentBeeGroup > 0 && currentEaterGroup != 0) {
                bees.offerFirst(currentBeeGroup); // Return the remaining bees to the front of the queue
            } else if (currentBeeGroup > 0) {
                bees.offer(currentBeeGroup);
            }

            if (currentEaterGroup > 0) {
                eaters.push(currentEaterGroup); // The bee-eater survives and fights again
            }

        }
        System.out.println("The final battle is over!");
        if (bees.isEmpty() && eaters.isEmpty()){
            System.out.println("But no one made it out alive!");
        } else if (!bees.isEmpty()){
            String result = bees.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bee groups left: " + result);
        } else {
            List<Integer> reversed = new ArrayList<>(eaters);
            Collections.reverse(reversed);
            String result = reversed.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bee-eater groups left: " + result);
        }

    }
}
