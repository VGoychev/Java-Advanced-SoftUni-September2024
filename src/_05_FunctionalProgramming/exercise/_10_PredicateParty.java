package _05_FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> predicate;
        List<String> people = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Party!")){
            String[] commandParts = command.split(" ");
            if (commandParts[1].equals("StartsWith")){
                predicate = s -> s.startsWith(commandParts[2]);
            } else if (commandParts[1].endsWith("EndsWith")){
                predicate = s -> s.endsWith(commandParts[2]);
            } else {
                predicate = s -> s.length() == Integer.parseInt(commandParts[2]);
            }
            if (commandParts[0].equals("Remove")){
                people.removeIf(predicate);
            } else if (commandParts[0].equals("Double")){
                List<String> peopleDouble = people.stream().filter(predicate).collect(Collectors.toList());
                people.addAll(peopleDouble);
            }
            command = scanner.nextLine();
        }
        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            String print = people.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(print + " are going to the party!");
        }
    }
}
