package _01_StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack for URLs visited
        ArrayDeque<String> backStack = new ArrayDeque<>();
        // Stack for URLs to go forward to
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                // Go back in history
                if (backStack.size() > 1) {
                    forwardStack.push(backStack.pop()); // Move the current URL to forward stack
                    System.out.println(backStack.peek()); // Print the previous URL
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                // Go forward in history
                if (!forwardStack.isEmpty()) {
                    backStack.push(forwardStack.pop()); // Move the URL from forward stack to back stack
                    System.out.println(backStack.peek()); // Print the current URL
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                // Normal navigation to a new URL
                if (!backStack.isEmpty()) {
                    forwardStack.clear(); // Clear the forward stack because new navigation occurs
                }
                backStack.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
