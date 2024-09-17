package _03_SetsAndDictionaries.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new TreeMap<>();
        while (true){
            String input = scanner.nextLine();
            if (input.equals("search")){
                break;
            }
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.put(name, number);
        }
        while (true){
            String input = scanner.nextLine();
            if (input.equals("stop")){
                break;
            }
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
        }
    }
}
