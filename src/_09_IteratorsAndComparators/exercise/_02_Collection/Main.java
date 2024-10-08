package _09_IteratorsAndComparators.exercise._02_Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = new ListyIterator();

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] commandParts = command.split("\\s+");
            String input = commandParts[0];
            if (input.equals("Create")){
                if (commandParts.length > 1){
                    String[] elements = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                    listyIterator = new ListyIterator(elements);
                }
            } else if (input.equals("Move")){
                System.out.println(listyIterator.move());
            } else if (input.equals("Print")) {
                try {
                    listyIterator.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            } else if (input.equals("PrintAll")){
                listyIterator.printAll();
            }
            command = scanner.nextLine();
        }
    }
}
