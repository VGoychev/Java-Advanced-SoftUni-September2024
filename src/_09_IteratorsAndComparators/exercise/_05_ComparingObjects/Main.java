package _09_IteratorsAndComparators.exercise._05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int matcher = 1;
        int unmatcher = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            personList.add(person);
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person myPerson = personList.get(n - 1); // Gosho
        personList.remove(myPerson);
        for (Person person : personList){
            int result = myPerson.compareTo(person);
            if (result == 0){
                matcher++;
            } else {
                unmatcher++;
            }
        }
        if (matcher != 1){
            System.out.println(matcher + " " + unmatcher + " " + (personList.size()+1));
        } else {
            System.out.println("No matches");
        }


    }
}
