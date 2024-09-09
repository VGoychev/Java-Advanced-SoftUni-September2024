package _01_StacksAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kidNames = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, kidNames);

        int n = Integer.parseInt(scanner.nextLine());
        int rotations = 0;

        while (queue.size() > 1) {
            String firstKid = queue.poll();

            rotations++;

            if (rotations % n == 0) {

                System.out.println("Removed " + firstKid);
            } else {

                queue.offer(firstKid);
            }
        }

        System.out.println("Last is "+ queue.poll());
    }
}
