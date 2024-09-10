package _01_StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '('){
                stack.push(i);
            } else if (currentChar == ')'){
                int startIndex = stack.pop();
                int endIndex = i + 1;

                String subExpression = input.substring(startIndex,endIndex);
                System.out.println(subExpression);

            }
        }
    }
}
