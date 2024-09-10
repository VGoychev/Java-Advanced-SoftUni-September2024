package _01_StackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")){
            if (input.equals("back")){
                //back
                if (stack.size() > 1){
                    stack.pop();
                    System.out.println(stack.peek());
                } else{
                    System.out.println("no previous URLs");
                }
            } else {
                //URL
                stack.push(input);
                System.out.println(input);
            }


            input = scanner.nextLine();
        }
    }
}
