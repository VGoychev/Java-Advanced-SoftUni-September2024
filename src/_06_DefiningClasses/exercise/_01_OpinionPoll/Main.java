package _06_DefiningClasses.exercise._01_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        Person person;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            person = new Person(name,age);
            personList.add(person);
        }
        personList.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getName(), entry.getAge()));
    }
}
