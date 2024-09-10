package _01_StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] commands = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int command = commands[0];
            switch (command){
                case 1:
                   int x = commands[1];
                   stack.push(x);
                   break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int highestNumber = stack.peek();
                    for (int element : stack){
                        if (highestNumber < element){
                            highestNumber = element;
                        }
                    }
                    System.out.println(highestNumber);
                    break;
            }
        }
    }
}
