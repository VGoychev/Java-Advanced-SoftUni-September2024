package _01_StackAndQueue.lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kidNames = scanner.nextLine().split(" ");
        PriorityQueue<String> queue = new PriorityQueue<>();

        // Add all kid names to the queue
        for (String kid : kidNames) {
            queue.offer(kid);
        }

        int n = Integer.parseInt(scanner.nextLine());
        int rotations = 0;

        // Process the queue until only one child remains
        while (queue.size() > 1) {
            rotations++;

            // Rotate n-1 times
            for (int i = 0; i < n - 1; i++) {
                String kid = queue.poll();
                queue.offer(kid);  // Move kid to the back of the queue
            }

            // Get the next kid for evaluation
            String currentKid = queue.poll();

            // Prime number check
            boolean isPrime = true;
            if (rotations <= 1) {
                isPrime = false;  // 1 is not a prime number
            } else {
                for (int i = 2; i <= Math.sqrt(rotations); i++) {
                    if (rotations % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // If prime cycle, print the child's name
            if (isPrime) {
                System.out.println("Prime " + currentKid);
                queue.offer(currentKid); // Re-add the kid since it's a prime cycle
            } else {
                // If composite cycle, remove the child
                System.out.println("Removed " + currentKid);
            }
        }

        // Print the last remaining child
        System.out.println("Last is " + queue.poll());
    }
}
