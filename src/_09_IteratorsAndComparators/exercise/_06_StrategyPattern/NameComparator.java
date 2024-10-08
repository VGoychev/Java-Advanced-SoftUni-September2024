package _09_IteratorsAndComparators.exercise._06_StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    public int compare(Person person1, Person person2){
        int result = Integer.compare(person1.getName().length(), person2.getName().length());
        if (result == 0){
            char f = Character.toLowerCase(person1.getName().charAt(0));
            char s = Character.toLowerCase(person2.getName().charAt(0));

            result = Character.compare(f, s);
        }
        return result;
    }
}
