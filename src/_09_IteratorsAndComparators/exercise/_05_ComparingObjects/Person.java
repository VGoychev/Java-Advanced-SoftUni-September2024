package _09_IteratorsAndComparators.exercise._05_ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town){
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public int compareTo(Person otherPerson){
        int resultName = this.name.compareTo(otherPerson.name);
        if (resultName == 0){
            resultName = Integer.compare(this.age, otherPerson.age);
            if (resultName == 0){
                resultName = this.town.compareTo(otherPerson.town);
            }
        }
        return resultName;
    }
}
