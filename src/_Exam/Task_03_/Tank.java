package _Exam.Task_03_;

public class Tank {
    private String brand;
    private String model;
    private int weight;
    private int barrelCaliber;
    private int armor;

    @Override
    public String toString() {
        return "Brand: " + getBrand() + ", Model: " + getModel() + ", Weight: "
                + getWeight() + "kg, Barrel caliber: " + getBarrelCaliber() + "mm, Armor: " + getArmor() + "mm";
    }

    public Tank(String brand, String model, int weight, int barrelCaliber, int armor) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.barrelCaliber = barrelCaliber;
        this.armor = armor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBarrelCaliber() {
        return barrelCaliber;
    }

    public void setBarrelCaliber(int barrelCaliber) {
        this.barrelCaliber = barrelCaliber;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
