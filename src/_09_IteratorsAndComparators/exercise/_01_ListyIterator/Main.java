package _09_IteratorsAndComparators.exercise._01_ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = new ListyIterator();
        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");
            String input = tokens[0];
            if (input.equals("Create")){
                if (tokens.length > 1){
                    String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
                    listyIterator = new ListyIterator(elements);
                }
            } else if (command.equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (command.equals("Print")) {
                try {
                    listyIterator.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            }
            command = scanner.nextLine();
        }
    }
}
