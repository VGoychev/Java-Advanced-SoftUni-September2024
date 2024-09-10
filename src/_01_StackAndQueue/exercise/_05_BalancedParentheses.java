package _01_StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // Flag to keep track of whether the sequence is balanced
        boolean isBalanced = true;

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // If it's an opening parenthesis, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                // If it's a closing parenthesis
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char last = stack.pop();

                if ((ch == ')' && last != '(') ||
                        (ch == '}' && last != '{') ||
                        (ch == ']' && last != '[')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        // If the stack is not empty at the end, the sequence is unbalanced
        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        // Output the result
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
