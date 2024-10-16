package _ExamPreparation_03_.Task_03_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSpacecraft(Spacecraft spacecraft){
        if (spacecrafts.size() >= capacity){
            System.out.println("This launchpad is at full capacity!");
        } else {
            spacecrafts.add(spacecraft);
        }
    }
    public boolean removeSpacecraft(String name){
        Spacecraft spacecraft = this.getSpacecraft(name);
        spacecrafts.remove(spacecraft);
        return spacecraft != null;
    }
    public Spacecraft getSpacecraft(String name){
        return spacecrafts.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return spacecrafts.size();
    }
    public String getHeaviestSpacecraft(){
        Spacecraft heaviestSpacecraft = spacecrafts.stream().max(Comparator.comparing(Spacecraft::getWeight)).orElse(null);
        if (heaviestSpacecraft != null){
            return heaviestSpacecraft.getName() + " - " + heaviestSpacecraft.getWeight() +"kg.";
        }
        return null;
    }
    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftList = spacecrafts.stream().filter(s -> s.getMissionType().equals(missionType)).collect(Collectors.toList());

        if (spacecraftList.isEmpty()){
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftList;
    }
    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        if (spacecrafts.isEmpty()){
            builder.append("Spacecrafts launched from ").append(getName()).append(":");
            builder.append(System.lineSeparator());
            builder.append("none");
        } else {
            builder.append("Spacecrafts launched from ").append(getName()).append(":");
            builder.append(System.lineSeparator());

            for (int i = 0; i < spacecrafts.size(); i++) {
                builder.append(i + 1).append(". ").append(spacecrafts.get(i).getName())
                        .append(System.lineSeparator());
            }
        }

        return builder.toString();
    }
}
