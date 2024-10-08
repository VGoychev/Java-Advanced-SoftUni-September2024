package _09_IteratorsAndComparators.exercise._03_StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\s+");
        CustomStack customStack = new CustomStack();

        while (!command[0].equals("END")){
            if (command[0].equals("Push")) {
                StringBuilder format = new StringBuilder();
                for (int i = 1; i < command.length; i++) {
                    format.append(command[i]);
                }

                String[] numbers = format.toString().split(",");

                for (int i = 0; i < numbers.length; i++) {
                    customStack.push(Integer.parseInt(numbers[i]));
                }
            } else {
                try {
                    customStack.pop();
                } catch (OperationNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            command = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < 2; i++) {
            for (int j = customStack.getStack().size() - 1; j >= 0; j--) {
                System.out.println(customStack.getStack().get(j));
            }
        }
    }
}
