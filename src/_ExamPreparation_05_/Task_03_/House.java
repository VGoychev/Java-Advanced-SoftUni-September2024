package _ExamPreparation_05_.Task_03_;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid){
        if (data.size() < capacity){
            data.add(kid);
        }
    }
    public boolean removeKid(String name){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(name)){
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String street){
        return data.stream().filter(k -> k.getStreet().equals(street)).findFirst().orElse(null);
    }
    public int getAllKids(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:")
                .append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i).getName()).append(" from ").append(data.get(i).getStreet()).append(" street")
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
