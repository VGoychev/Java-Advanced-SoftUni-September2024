package _06_DefiningClasses.exercise._07_Google;

public class Parent {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
