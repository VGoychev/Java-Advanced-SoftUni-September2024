package _01_StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] command = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = command[0];
        int s = command[1];
        int x = command[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int element = 0;
        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }
        for (int j = 0; j < s; j++) {
            element = stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println(0);
        } else {
            if (stack.contains(x)){
                System.out.println(true);
            } else {
                int smallestNumber = stack.peek();
                for (int number : stack) {
                    if(number < smallestNumber) {
                        smallestNumber = number;
                    }
                }
                System.out.println(smallestNumber);
            }
        }

    }
}
