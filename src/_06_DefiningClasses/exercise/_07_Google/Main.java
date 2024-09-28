package _06_DefiningClasses.exercise._07_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Person person;
        Company company;
        Car car;
        Pokemon pokemon;
        Parent parent;
        Child child;
        Map<String, Person> personMap = new LinkedHashMap<>();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            String personName = tokens[0];
            String informationType = tokens[1];
            if (personMap.containsKey(personName)){
                person = personMap.get(personName);
            } else {
                person = new Person(personName);
            }
            if (informationType.equals("company")){
                String companyName = tokens[2];
                String companyDepartment = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                company = new Company(companyName, companyDepartment, salary);
                person.setCompany(company);
            } else if ( informationType.equals("pokemon")){
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                pokemon = new Pokemon(pokemonName, pokemonType);
                person.addPokemon(pokemon);
            } else if (informationType.equals("parents")) {
                String parentName = tokens[2];
                String parentBirthday = tokens[3];

                parent = new Parent(parentName, parentBirthday);
                person.addParent(parent);
            } else if (informationType.equals("children")){
                String childName = tokens[2];
                String childBirthday = tokens[3];

                child = new Child(childName, childBirthday);

                person.addChild(child);
            } else if (informationType.equals("car")) {
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);

                car = new Car(carModel, carSpeed);

                person.setCar(car);
            }

            personMap.putIfAbsent(personName, person);
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        personMap.get(command).printPersonInfo(personMap.get(command));
    }
}
