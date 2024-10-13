package _ExamPreparation_02_.Task_03_;

public class Surfer {
    private String name;
    private int age;
    private int experience;
    private Boolean ownsASurfBoard;
    private int money;

    public Surfer(String name, int age, int experience,
                  Boolean ownsASurfBoard, int money){
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownsASurfBoard = ownsASurfBoard;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Surfer " + getName() + " is " + getAge() +
                " years old and has " + getExperience() + " years surfing experience.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Boolean getOwnsASurfBoard() {
        return ownsASurfBoard;
    }

    public void setOwnsASurfBoard(Boolean ownsASurfBoard) {
        this.ownsASurfBoard = ownsASurfBoard;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
