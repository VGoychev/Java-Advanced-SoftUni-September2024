package _01_StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {

            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            int result = 0;
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }
            stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
