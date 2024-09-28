package _06_DefiningClasses.exercise._03_RawData;

public class Tires {
    private double tyre1Pressure;
    private int tyre1Age;
    private double tyre2Pressure;
    private int tyre2Age;
    private double tyre3Pressure;
    private int tyre3Age;
    private double tyre4Pressure;
    private int tyre4Age;

    public double getTyre1Pressure() {
        return tyre1Pressure;
    }

    public void setTyre1Pressure(double tyre1Pressure) {
        this.tyre1Pressure = tyre1Pressure;
    }

    public int getTyre1Age() {
        return tyre1Age;
    }

    public void setTyre1Age(int tyre1Age) {
        this.tyre1Age = tyre1Age;
    }

    public double getTyre2Pressure() {
        return tyre2Pressure;
    }

    public void setTyre2Pressure(double tyre2Pressure) {
        this.tyre2Pressure = tyre2Pressure;
    }

    public int getTyre2Age() {
        return tyre2Age;
    }

    public void setTyre2Age(int tyre2Age) {
        this.tyre2Age = tyre2Age;
    }

    public double getTyre3Pressure() {
        return tyre3Pressure;
    }

    public void setTyre3Pressure(double tyre3Pressure) {
        this.tyre3Pressure = tyre3Pressure;
    }

    public int getTyre3Age() {
        return tyre3Age;
    }

    public void setTyre3Age(int tyre3Age) {
        this.tyre3Age = tyre3Age;
    }

    public double getTyre4Pressure() {
        return tyre4Pressure;
    }

    public void setTyre4Pressure(double tyre4Pressure) {
        this.tyre4Pressure = tyre4Pressure;
    }

    public int getTyre4Age() {
        return tyre4Age;
    }

    public void setTyre4Age(int tyre4Age) {
        this.tyre4Age = tyre4Age;
    }


    public Tires(double tyre1Pressure, int tyre1Age, double tyre2Pressure, int tyre2Age, double tyre3Pressure, int tyre3Age, double tyre4Pressure, int tyre4Age) {
        this.tyre1Pressure = tyre1Pressure;
        this.tyre1Age = tyre1Age;
        this.tyre2Pressure = tyre2Pressure;
        this.tyre2Age = tyre2Age;
        this.tyre3Pressure = tyre3Pressure;
        this.tyre3Age = tyre3Age;
        this.tyre4Pressure = tyre4Pressure;
        this.tyre4Age = tyre4Age;
    }
}
