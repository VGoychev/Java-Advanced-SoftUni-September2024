package _06_DefiningClasses.exercise._07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    List<Parent> parents;
    List<Child> children;
    List<Pokemon> pokemons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    public void addParent(Parent parent) {
        this.parents.add(parent);
    }
    public void addChild(Child child) {
        this.children.add(child);
    }

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

        public void printPersonInfo(Person person){
            System.out.printf("%s%n", person.getName());
            System.out.printf("Company:%n");
            if (!(person.getCompany() == null)) {
                System.out.printf("%s %s %.2f%n", person.getCompany().getName(), person.getCompany().getDepartment(), person.getCompany().getSalary());
            }
            System.out.printf("Car:%n");
            if (!(person.getCar() == null)) {
                System.out.printf("%s %d%n", person.getCar().getModel(), person.getCar().getSpeed());
            }
            System.out.printf("Pokemon:%n");
            if (!(person.getPokemons().isEmpty())) {
                person.getPokemons().forEach(pokemon -> {
                    System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
                });
            }
            System.out.printf("Parents:%n");
            if (!(person.getParents().isEmpty())) {
                person.getParents().forEach(parents -> {
                    System.out.printf("%s %s%n", parents.getName(), parents.getBirthday());
                });
            }
            System.out.printf("Children:%n");
            if (!(person.getChildren().isEmpty())) {
                person.getChildren().forEach(children -> {
                    System.out.printf("%s %s%n", children.getName(), children.getBirthday());
                });
            }
        }
    }
