package _06_DefiningClasses.exercise._07_Google;

public class Pokemon {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
