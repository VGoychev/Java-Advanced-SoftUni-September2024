package _01_StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = elements[0];
        int s = elements[1];
        int x = elements[2];

        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
        } else {
            if (queue.contains(x)){
                System.out.println(true);
            } else {
                int smallestNumber = queue.peek();
                for (int number : queue){
                    if (smallestNumber > number){
                        smallestNumber = number;
                    }
                }
                System.out.println(smallestNumber);
            }

        }


    }
}
