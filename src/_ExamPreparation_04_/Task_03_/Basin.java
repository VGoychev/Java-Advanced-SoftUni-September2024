package _ExamPreparation_04_.Task_03_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {
   private String name;
   private int capacity;
   private List<Shark> sharks;

    public String getName() {
        return name;
    }

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }
    public void addShark(Shark shark){
        if (sharks.size() < capacity){
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }
    public boolean removeShark(String kind){
        for (int i = 0; i < sharks.size(); i++) {
            if(sharks.get(i).getKind().equals(kind)){
                sharks.remove(i);
                return true;
            }
        }
        return false;
    }
    public Shark getLargestShark(){
        Shark largestShark = sharks.stream().max(Comparator.comparing(Shark::getLength)).orElse(null);
        if (largestShark != null){
            return largestShark;
        }
        return null;
    }
    public Shark getShark(String kind){
        return sharks.stream().filter(s -> s.getKind().equals(kind)).findFirst().orElse(null);
    }
    public int getCount(){
        return sharks.size();
    }
    public int getAverageLength(){
        int sharkLengths = 0;
        for (Shark shark : sharks) {
            sharkLengths += shark.getLength();
        }
        return sharkLengths / sharks.size();

    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Sharks in ").append(getName()).append(":");
        sb.append(System.lineSeparator());
        for (int i = 0; i < sharks.size(); i++) {
            sb.append("The ").append(sharks.get(i).getKind()).append(" is ")
                    .append(sharks.get(i).getLength()).append(" centimeters long, eats ").append(sharks.get(i).getFood())
                    .append(" and inhabits ").append(sharks.get(i).getHabitation()).append(".")
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
