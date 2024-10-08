package _09_IteratorsAndComparators.exercise._06_StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> personByName = new TreeSet<>(new NameComparator());
        Set<Person> personByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            personByName.add(person);
            personByAge.add(person);
        }

        for (Person person : personByName) {
            System.out.println(person.toString());
        }

        for (Person person : personByAge) {
            System.out.println(person.toString());
        }
    }
}
