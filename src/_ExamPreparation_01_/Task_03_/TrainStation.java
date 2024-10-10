package _ExamPreparation_01_.Task_03_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge){
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addLocomotive(Locomotive locomotive){
        if (capacity > locomotives.size() && railGauge == locomotive.getGauge()){
            locomotives.add(locomotive);
        } else if (railGauge != locomotive.getGauge()){
            System.out.println("The rail gauge of this station does not match the locomotive gauge! Difference: " + Math.abs(railGauge - locomotive.getGauge()) + " mm.");
        } else {
            System.out.println("This train station is full!");
        }
    }
    public boolean removeLocomotive(String name){
        for (Locomotive locomotive : locomotives){
            if (name.equals(locomotive.getName())){
                locomotives.remove(locomotive);
                return true;
            }
        }
        return false;
    }
    public String getFastestLocomotive(){
        Locomotive fastestLocomotive = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).orElse(null);
        if (fastestLocomotive != null){
            return fastestLocomotive.getName() + " is the fastest locomotive with a maximum speed of " + fastestLocomotive.getMaxSpeed() + " km/h.";
        }
        return "There are no locomotives.";
    }
    public Locomotive getLocomotive(String name){
        for (Locomotive locomotive : locomotives){
            if (name.equals(locomotive.getName())){
                return locomotive;
            }
        }
        return null;
    }
    public int getCount(){
        return locomotives.size();
    }
    public String getOldestLocomotive(){
        Locomotive oldestLocomotive = locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).orElse(null);
        if (oldestLocomotive != null){
            return oldestLocomotive.getName();
        }
        return "There are no locomotives.";
    }
    public String getStatistics(){

        TrainStation trainStation = new TrainStation(getName(), getCapacity(), railGauge);
        StringBuilder build = new StringBuilder();

        if (locomotives.isEmpty()) {
            build.append(System.lineSeparator()).append("There are no locomotives departing from ").append(trainStation.getName()).append(" station.");
        } else {
            build.append("Locomotives departed from ").append(trainStation.getName()).append(":");
            build.append(System.lineSeparator());

            for (int i = 0; i < locomotives.size(); i++) {
                build.append(i + 1).append(". ").append(locomotives.get(i).getName()).append(System.lineSeparator());
            }
        }

        return build.toString().trim();
    }
}
